package com.dsoumaila.hexaarchi.infrastructure.adapters.output.persistence;

import com.dsoumaila.hexaarchi.application.output.ProductOutputPort;
import com.dsoumaila.hexaarchi.domain.model.Product;
import com.dsoumaila.hexaarchi.infrastructure.adapters.output.persistence.entity.ProductEntity;
import com.dsoumaila.hexaarchi.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import com.dsoumaila.hexaarchi.infrastructure.adapters.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {
    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toProductEntity(product);
        productEntity = productRepository.save(productEntity);
        return productPersistenceMapper.toProduct(productEntity);
    }

    @Override
    public Set<Product> getProducts() {
        Set<Product> products = productRepository.findAll()
                .stream()
                .map(productPersistenceMapper::toProduct)
                .collect(toSet());
        return products;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isEmpty()) return Optional.empty();

        Product product = productPersistenceMapper.toProduct(productEntity.get());
        return  Optional.of(product);
    }

    @Override
    public void deleteProduct(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toProductEntity(product);
        productRepository.delete(productEntity);
    }
}
