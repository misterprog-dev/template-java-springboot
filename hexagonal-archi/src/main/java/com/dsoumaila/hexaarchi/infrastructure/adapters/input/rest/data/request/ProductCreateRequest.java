package com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCreateRequest {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message="Description is required")
    private String description;
}
