package com.lab3.book.services;

import com.lab3.book.models.Book;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface BookService {

    Book addBook(Book book);
    void deleteBookById(Long rollNo);
    List<Book> findAllBooks();
    Book updateBook(Book book);
    @Cacheable("books")
    Book findBookById(Long id);
   // @Cacheable("books")
    //public List<Book> findBookByTitle(String title);

}
