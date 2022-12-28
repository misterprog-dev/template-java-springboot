package com.dsoumaila.swagger.domain;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BookVoFactory {
    public BookVO bookVO(Book book) {
        return new BookVO(book);
    }

    public List<BookVO> booksVO(List<Book> books) {
        return books.stream()
                .map(BookVO::new)
                .collect(toList());
    }
}
