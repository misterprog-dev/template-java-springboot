package com.dsoumaila.hexaarchi.domain.event;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdatedEvent {
    private Long id;
    private String name;
    private LocalDateTime date;

    public ProductUpdatedEvent(Long id, String name) {
        this.id = id;
        this.name = name;
        this.date = LocalDateTime.now();
    }
}
