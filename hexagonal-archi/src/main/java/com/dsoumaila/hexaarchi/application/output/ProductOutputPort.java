package com.dsoumaila.hexaarchi.application.output;

import com.dsoumaila.hexaarchi.domain.model.Product;

import java.util.Optional;
import java.util.Set;

public interface ProductOutputPort {
    Product saveProduct(Product product);
    Set<Product> getProducts();
    Optional<Product> getProductById(Long id);
    void deleteProduct(Product product);
}
