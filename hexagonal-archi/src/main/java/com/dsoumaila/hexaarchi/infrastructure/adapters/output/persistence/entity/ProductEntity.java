package com.dsoumaila.hexaarchi.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = ProductEntity.TABLE_NAME)
@Access(AccessType.FIELD)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
    public static final String TABLE_NAME = "product";
    public static final String TABLE_ID = TABLE_NAME + "_ID";
    private static final String TABLE_SEQ = TABLE_ID + "_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    private Long id;

    @NotNull(message = "The name can't be null")
    private String name;

    @NotNull(message = "The description can't be null")
    private String description;
}
