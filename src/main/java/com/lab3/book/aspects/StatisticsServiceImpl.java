package com.lab3.book.aspects;


import com.lab3.book.aspects.Statistics;
import com.lab3.book.aspects.StatisticsRepository;
import com.lab3.book.aspects.StatisticsService;
import com.lab3.book.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    private Book newestBook;

    private Book oldestBook;

    @Override
    public List<Statistics> getAllStatistic() {

        List<Object> s = statisticsRepository.listOfAllStatisctics();
        List<Statistics> statisticsList = new ArrayList<Statistics>();
        for (Object cdata:s) {
            Object[] obj= (Object[]) cdata;
            String method = (String)obj[0];
            String classname = (String)obj[1];
            Long numberLong = (Long)obj[2];
            Statistics tmp = new Statistics(classname,method, numberLong.intValue());
            statisticsList.add(tmp);
        }

        return statisticsList ;

    }

    @Override
    public Integer countAllMethodsCalls() {
        return statisticsRepository.countAllMethodsCalls();
    }

    @Override
    public Statistics addStatistics(String className, String methodName) {
        Statistics s= new Statistics(className, methodName,1);
        return statisticsRepository.save(s);
    }

    @Override
    public void setNewestBook(Book book) {
        this.newestBook = book;
    }

    @Override
    public Book getNewestBook() {
        return this.newestBook;
    }

    @Override
    public void setOldestBook(Book book) {
       this.oldestBook = book;
    }

    @Override
    public Book getOldestBook() {
        return this.oldestBook;
    }

}
