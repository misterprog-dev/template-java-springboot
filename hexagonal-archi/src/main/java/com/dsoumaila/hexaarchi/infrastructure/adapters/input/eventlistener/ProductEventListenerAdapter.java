package com.dsoumaila.hexaarchi.infrastructure.adapters.input.eventlistener;

import com.dsoumaila.hexaarchi.domain.event.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductEventListenerAdapter {
    @EventListener
    public void handle(ProductCreatedEvent event) {
        log.info("Product created with ID=" + event.getId() + " at " + event.getDate());
    }

    @EventListener
    public void handle(ProductsGotEvent event) {
        log.info("Products getting with ID=" + event.getIds() + " at " + event.getDate());
    }

    @EventListener
    public void handle(ProductGotEvent event) {
        log.info("Product getting with ID=" + event.getId() + " at " + event.getDate());
    }

    @EventListener
    public void handle(ProductUpdatedEvent event) {
        log.info("Product (" + event.getId() + " , " + event.getName() + ") updated at " + event.getDate());
    }

    @EventListener
    public void handle(ProductDeletedEvent event) {
        log.info("Product With ID " + event.getId() + " deleted at " + event.getDate());
    }
}
