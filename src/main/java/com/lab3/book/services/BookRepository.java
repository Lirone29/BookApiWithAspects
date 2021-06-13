package com.lab3.book.services;

import com.lab3.book.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query("update Book b set b.title = ?1, b.author = ?2, b.info = ?3, b.year = ?4 where b.id = ?5")
    void updateBookById(String title, String author, String info, Long year, Long id);


    @Modifying
    @Query("update Book b set b.title = ?1, b.author = ?2, b.info = ?3, b.year = ?4 where b.id = ?5")
    void updateBookById(String title, String author, String info, String year, Long id);

    @Modifying
    @Query("update Book b set b.title = ?1, b.author = ?2, b.info = ?3, b.year = ?4 where b.id = ?5")
    void updateBookById(String title, String author, String info, String year, String id);

    /*

    @Query("SELECT b FROM books where b.year = (SELECT min(year) FROM books)")
    Book findOldestBook();

    @Query("SELECT b FROM books where b.year = (SELECT max(year) FROM books)")
    Book findNewestBook();*/
}
