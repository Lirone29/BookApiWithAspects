package com.lab3.book.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab3.book.models.Book;
import com.lab3.book.models.BookPath;
import com.lab3.book.models.Books;
import com.lab3.book.services.BookService;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/")
public class BookApiController {

    @Autowired
    private BookService bookService;

    private static final Logger log = LoggerFactory.getLogger(BookApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BookApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/book/{bookId}/download", produces = { "application/json", "application/xml" }, method = RequestMethod.GET)
    public ResponseEntity<Resource> dwonloadBook(@PathVariable("bookId") Long bookId) {
        return new ResponseEntity<Resource>(HttpStatus.NOT_IMPLEMENTED);
    }


    @RequestMapping(value = "/book/findByAuthor/{author}", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable("author") String author) {
        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }


    @RequestMapping(value = "/book/findByTitle/{title}", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<Book>> findBooksByTitle(@PathVariable("title") String title) {
        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }


    @RequestMapping(value = "/book/findByUsername/{username}", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<Book>> findBooksByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }


    @RequestMapping(value = "/book", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<Books> getAllBooks() {
        Books books = new Books();
        books.setBooks(bookService.findAllBooks());
        return ResponseEntity.ok(books);
    }


    @RequestMapping(value = "/book/{bookId}", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<Book> getBook(@PathVariable("bookId") Long bookId) {
        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/book", produces = { "application/xml", "application/json" }, method = RequestMethod.POST)
    public ResponseEntity<Book> postBook(@RequestBody Book book) {
        System.out.println("In the middle of creation " + book.getTitle());
        return ResponseEntity.ok(bookService.addBook(book));
    }


    @RequestMapping(value = "/book/{bookId}/read", produces = { "application/json", "application/xml" }, method = RequestMethod.GET)
    public ResponseEntity<String> readBook(@PathVariable("bookId") Long bookId) {
        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }


    @RequestMapping(value = "/book/{bookId}", produces = { "application/xml", "application/json" }, method = RequestMethod.PUT)
    public  ResponseEntity<Book> updateBook( @PathVariable("bookId") Long bookId, @RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @RequestMapping(value = "/book/{bookId}/uploadBook", produces = { "application/xml", "application/json" }, method = RequestMethod.POST)
    public ResponseEntity<Book> uploadBookFile(@PathVariable("bookId") Long bookId,@RequestBody BookPath bookPath) {
        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }


}
