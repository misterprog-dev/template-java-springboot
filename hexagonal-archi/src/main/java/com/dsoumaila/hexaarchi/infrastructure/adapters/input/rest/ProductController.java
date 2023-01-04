package com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest;

import com.dsoumaila.hexaarchi.application.input.CreateProductUseCase;
import com.dsoumaila.hexaarchi.application.input.DeleteProductUseCase;
import com.dsoumaila.hexaarchi.application.input.GetProductUseCase;
import com.dsoumaila.hexaarchi.application.input.UpdateProductUseCase;
import com.dsoumaila.hexaarchi.domain.model.Product;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.request.ProductCreateRequest;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.request.ProductUpdateRequest;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.response.ProductCreateOrUpdateResponse;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.response.ProductGettingResponse;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.response.ProductsGettingResponse;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.mapper.ProductRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/v1/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final ProductRestMapper productRestMapper;

    @PostMapping
    public ResponseEntity<ProductCreateOrUpdateResponse> createProduct(@RequestBody @Validated ProductCreateRequest productCreateRequest) {
        Product product = productRestMapper.toProduct(productCreateRequest);
        product = createProductUseCase.createProduct(product);
        return new ResponseEntity<>(productRestMapper.toProductCreateOrUpdateResponse(product), CREATED);
    }

    @GetMapping
    public ResponseEntity<Set<ProductsGettingResponse>> getProducts() {
        Set<Product> products = getProductUseCase.getProducts();
        return new ResponseEntity<>(productRestMapper.toProductsGettingResponse(products), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductGettingResponse> getProduct(@PathVariable Long id) {
        Product product = getProductUseCase.getProductById(id);
        return new ResponseEntity<>(productRestMapper.toProductGettingResponse(product), OK);
    }

    @PutMapping
    public ResponseEntity<ProductCreateOrUpdateResponse> updateProduct(@RequestBody @Validated ProductUpdateRequest productUpdateRequest) {
        Product product = productRestMapper.toProduct(productUpdateRequest);
        product = updateProductUseCase.updateProduct(product);
        return new ResponseEntity<>(productRestMapper.toProductCreateOrUpdateResponse(product), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        deleteProductUseCase.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
