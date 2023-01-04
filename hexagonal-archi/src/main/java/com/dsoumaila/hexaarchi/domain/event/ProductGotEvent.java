package com.dsoumaila.hexaarchi.domain.event;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductGotEvent {
    private Long id;
    private LocalDateTime date;

    public ProductGotEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }
}
