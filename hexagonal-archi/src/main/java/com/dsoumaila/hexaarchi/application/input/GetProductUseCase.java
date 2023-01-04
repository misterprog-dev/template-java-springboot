package com.dsoumaila.hexaarchi.application.input;

import com.dsoumaila.hexaarchi.domain.model.Product;

import java.util.Set;

public interface GetProductUseCase {
    Set<Product> getProducts();
    Product getProductById(Long id);
}
