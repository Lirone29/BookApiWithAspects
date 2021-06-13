package com.lab3.book.aspects;

import com.lab3.book.aspects.Statistics;
import com.lab3.book.models.Book;


import java.util.List;

public interface StatisticsService {
    List<Statistics> getAllStatistic();
    Integer countAllMethodsCalls();
    Statistics addStatistics(String className, String methodName);

    void setNewestBook(Book book);
    Book getNewestBook();
    void setOldestBook(Book book);
    Book getOldestBook();
}
