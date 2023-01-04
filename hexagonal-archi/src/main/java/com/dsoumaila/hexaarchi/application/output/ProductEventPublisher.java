package com.dsoumaila.hexaarchi.application.output;

import com.dsoumaila.hexaarchi.domain.event.*;

public interface ProductEventPublisher {
    void publishProductCreatedEvent(ProductCreatedEvent event);
    void publishGetProductsEvent(ProductsGotEvent event);
    void publishGetProductEvent(ProductGotEvent event);
    void publishUpdateProductEvent(ProductUpdatedEvent event);
    void publishDeleteProductEvent(ProductDeletedEvent productDeletedEvent);
}
