package com.dsoumaila.swagger.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BookVO implements Serializable {
    private String title;
    private String description;

    public BookVO(Book book) {
        this.title = book.getTitle();
        this.description = book.getDescription();
    }
}
