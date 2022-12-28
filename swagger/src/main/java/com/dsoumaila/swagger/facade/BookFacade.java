package com.dsoumaila.swagger.facade;

import com.dsoumaila.swagger.Exception.BookDuplicateException;
import com.dsoumaila.swagger.domain.Book;
import com.dsoumaila.swagger.domain.BookVO;
import com.dsoumaila.swagger.domain.BookVoFactory;
import com.dsoumaila.swagger.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookFacade {
    private final BookRepository bookRepository;
    private final BookVoFactory bookVoFactory;

    public BookFacade(BookRepository bookRepository, BookVoFactory bookVoFactory) {
        this.bookRepository = bookRepository;
        this.bookVoFactory = bookVoFactory;
    }

    public void createBook(BookVO bookVO) throws BookDuplicateException {
        Book book = new Book(bookVO.getTitle(), bookVO.getDescription());
        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<BookVO> getBooks() {
        List<Book> books = bookRepository.findBy();
        return bookVoFactory.booksVO(books);
    }

}
