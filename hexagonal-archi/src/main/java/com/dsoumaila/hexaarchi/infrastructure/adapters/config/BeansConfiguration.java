package com.dsoumaila.hexaarchi.infrastructure.adapters.config;

import com.dsoumaila.hexaarchi.application.output.ProductEventPublisher;
import com.dsoumaila.hexaarchi.domain.service.ProductService;
import com.dsoumaila.hexaarchi.infrastructure.adapters.output.eventpublisher.ProductEventPublisherAdapter;
import com.dsoumaila.hexaarchi.infrastructure.adapters.output.persistence.ProductPersistenceAdapter;
import com.dsoumaila.hexaarchi.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import com.dsoumaila.hexaarchi.infrastructure.adapters.output.persistence.repository.ProductRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    @Bean
    ProductEventPublisherAdapter productEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new ProductEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    ProductPersistenceAdapter productPersistenceAdapter(ProductRepository productRepository, ProductPersistenceMapper productPersistenceMapper) {
        return new ProductPersistenceAdapter(productRepository, productPersistenceMapper);
    }

    @Bean
    ProductService productService(ProductPersistenceAdapter productPersistenceAdapter, ProductEventPublisher productEventPublisher) {
        return new ProductService(productPersistenceAdapter, productEventPublisher);
    }
}
