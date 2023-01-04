package com.dsoumaila.hexaarchi.infrastructure.adapters.output.persistence.mapper;

import com.dsoumaila.hexaarchi.domain.model.Product;
import com.dsoumaila.hexaarchi.infrastructure.adapters.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceMapper {
    ProductEntity toProductEntity(Product product);
    Product toProduct(ProductEntity productEntity);
}
