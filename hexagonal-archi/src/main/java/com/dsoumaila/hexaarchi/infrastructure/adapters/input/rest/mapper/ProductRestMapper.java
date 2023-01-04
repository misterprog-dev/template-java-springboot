package com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.mapper;

import com.dsoumaila.hexaarchi.domain.model.Product;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.request.ProductCreateRequest;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.request.ProductUpdateRequest;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.response.ProductCreateOrUpdateResponse;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.response.ProductGettingResponse;
import com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.response.ProductsGettingResponse;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface ProductRestMapper {
    Product toProduct(ProductCreateRequest productCreateRequest);
    Product toProduct(ProductUpdateRequest productUpdateRequest);
    ProductCreateOrUpdateResponse toProductCreateOrUpdateResponse(Product product);
    Set<ProductsGettingResponse> toProductsGettingResponse(Set<Product> products);
    ProductGettingResponse toProductGettingResponse(Product product);
}
