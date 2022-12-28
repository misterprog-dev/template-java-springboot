package com.dsoumaila.swagger.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Book.TABLE_NAME)
@Access(AccessType.FIELD)
public class Book {
    public static final String TABLE_NAME = "book";
    public static final String TABLE_ID = TABLE_NAME + "_ID";
    private static final String TABLE_SEQ = TABLE_ID + "_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    private Long id;

    @NotNull(message = "Title cannot be null")
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    public Book() {
    }

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
