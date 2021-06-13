package com.lab3.book.aspects;

import com.lab3.book.models.Book;

public class BookInfo {
    Book newestBook;
    Book oldestBook;

    public Book getNewestBook() {
        return newestBook;
    }

    public void setNewestBook(Book newestBook) {
        this.newestBook = newestBook;
    }

    public Book getOldestBook() {
        return oldestBook;
    }

    public void setOldestBook(Book oldestBook) {
        this.oldestBook = oldestBook;
    }
}
