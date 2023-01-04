package com.dsoumaila.hexaarchi.infrastructure.adapters.output.eventpublisher;

import com.dsoumaila.hexaarchi.application.output.ProductEventPublisher;
import com.dsoumaila.hexaarchi.domain.event.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class ProductEventPublisherAdapter implements ProductEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishProductCreatedEvent(ProductCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishGetProductsEvent(ProductsGotEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishGetProductEvent(ProductGotEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishUpdateProductEvent(ProductUpdatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishDeleteProductEvent(ProductDeletedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
