package com.dsoumaila.hexaarchi.domain.service;

import com.dsoumaila.hexaarchi.application.input.CreateProductUseCase;
import com.dsoumaila.hexaarchi.application.input.DeleteProductUseCase;
import com.dsoumaila.hexaarchi.application.input.GetProductUseCase;
import com.dsoumaila.hexaarchi.application.input.UpdateProductUseCase;
import com.dsoumaila.hexaarchi.application.output.ProductEventPublisher;
import com.dsoumaila.hexaarchi.application.output.ProductOutputPort;
import com.dsoumaila.hexaarchi.domain.event.*;
import com.dsoumaila.hexaarchi.domain.exception.ProductNotFound;
import com.dsoumaila.hexaarchi.domain.model.Product;
import lombok.AllArgsConstructor;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase,
        GetProductUseCase,
        UpdateProductUseCase,
        DeleteProductUseCase {
    private final ProductOutputPort productOutputPort;
    private final ProductEventPublisher productEventPublisher;

    @Override
    public Product createProduct(Product product) {
        product = productOutputPort.saveProduct(product);
        productEventPublisher.publishProductCreatedEvent(new ProductCreatedEvent(product.getId()));
        return product;
    }

    @Override
    public Set<Product> getProducts() {
        Set<Product> products = productOutputPort.getProducts();
        Set<Long> ids = products.stream()
                .map(Product::getId)
                .collect(toSet());
        productEventPublisher.publishGetProductsEvent(new ProductsGotEvent(ids));
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        productEventPublisher.publishGetProductEvent(new ProductGotEvent(id));
        return getProduct(id);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productToUpdate = getProduct(product.getId());
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate = productOutputPort.saveProduct(productToUpdate);
        productEventPublisher.publishUpdateProductEvent(new ProductUpdatedEvent(product.getId(), product.getName()));
        return productToUpdate;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProduct(id);
        productOutputPort.deleteProduct(product);
        productEventPublisher.publishDeleteProductEvent(new ProductDeletedEvent(product.getId()));
    }

    private Product getProduct(Long id) {
        return productOutputPort.getProductById(id)
                .orElseThrow(() -> new ProductNotFound("Product not found with ID=" + id));
    }
}
