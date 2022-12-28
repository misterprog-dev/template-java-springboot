package com.dsoumaila.swagger.repository;

import com.dsoumaila.swagger.domain.Book;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookRepository extends Repository<Book, Long> {
    List<Book> findBooksByTitleContainingIgnoreCase(String title);
    List<Book> findBooksByDescription(String description);
    List<Book> findBy();
    Book save(Book book);
}
