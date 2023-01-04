package com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductsGettingResponse {
    private Long id;
    private String name;
    private String description;
}
