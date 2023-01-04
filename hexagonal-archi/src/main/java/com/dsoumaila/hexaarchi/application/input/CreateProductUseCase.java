package com.dsoumaila.hexaarchi.application.input;

import com.dsoumaila.hexaarchi.domain.model.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
