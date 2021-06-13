package com.lab3.book.services;

import com.lab3.book.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        Optional<Book> os = bookRepository.findById(id);
        if(os.isPresent()) bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {

        System.out.println("In repository");
        bookRepository.updateBookById(book.getTitle(),book.getAuthor(), book.getInfo(),  book.getYear(), book.getId());
        return book;
    }

    @Override
    public Book findBookById(Long id) {

        Optional<Book> os = bookRepository.findById(id);
        if(os.isPresent()) return os.get();
        else return null;
    }


    /*
    @Override
    public List<Book> findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
        //return book;
    }


     */

}
