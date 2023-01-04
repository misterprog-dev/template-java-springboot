package com.dsoumaila.hexaarchi.domain.event;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductsGotEvent {
    private Set<Long> ids;
    private LocalDateTime date;

    public ProductsGotEvent(Set<Long> ids) {
        this.ids = ids;
        this.date = LocalDateTime.now();
    }
}
