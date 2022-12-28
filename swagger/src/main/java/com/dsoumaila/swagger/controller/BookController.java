package com.dsoumaila.swagger.controller;

import com.dsoumaila.swagger.Exception.BookDuplicateException;
import com.dsoumaila.swagger.domain.BookVO;
import com.dsoumaila.swagger.facade.BookFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {
    private final BookFacade bookFacade;

    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody BookVO bookVO) throws BookDuplicateException {
        bookFacade.createBook(bookVO);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookVO>> getAll() {
        List<BookVO> books = bookFacade.getBooks();
        return ResponseEntity.ok(books);
    }
}
