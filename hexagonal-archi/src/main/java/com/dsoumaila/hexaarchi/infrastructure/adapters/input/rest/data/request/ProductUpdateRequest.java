package com.dsoumaila.hexaarchi.infrastructure.adapters.input.rest.data.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductUpdateRequest {

    @NotNull(message = "ID can't be null")
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message="Description is required")
    private String description;
}
