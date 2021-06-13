package com.lab3.book.aspects;


import com.lab3.book.models.Book;
import com.lab3.book.models.Books;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Aspect
@Component
public class BookAspect {

    private final StatisticsService statisticsService;


    public BookAspect(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }


    @Around("execution(* com.lab3.book.controllers.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("In AspectEliza2");


        //Czy to wykorzsytać?
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        System.out.println( "Annotation " +getMethodName(joinPoint));

        statisticsService.addStatistics(getClassName(joinPoint), getMethodName(joinPoint));

        return proceed;
    }

    private String getClassName(ProceedingJoinPoint joinPoint) {
        return joinPoint.getTarget().getClass().getName();
    }

    private String getMethodName(ProceedingJoinPoint joinPoint) {
        return ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
    }


    @Around("execution(* com.lab3.book.controllers.BookApiController.getAllBooks() ) ")
    public Object getNewestBook(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = joinPoint.proceed();

        ResponseEntity<Books> r = (ResponseEntity<Books>)proceed;
        List<Book> people =  r.getBody().getBooks();;
        Book newestBook = people
                .stream()
                .min(Comparator.comparing(Book::getYear))
                .orElseThrow(NoSuchElementException::new);

        System.out.println( " min year " + newestBook.getYear());

        statisticsService.setNewestBook(newestBook);

        return proceed;
    }


    @Around("execution(* com.lab3.book.controllers.BookApiController.getAllBooks() ) ")
    public Object getOldestBook(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = joinPoint.proceed();
        List<Book> people =  ((ResponseEntity<Books>)proceed).getBody().getBooks();
        Book oldestBook = people
                .stream()
                .max(Comparator.comparing(Book::getYear))
                .orElseThrow(NoSuchElementException::new);


        statisticsService.setOldestBook(oldestBook);
        //statisticsService.addStatistics(getClassName(joinPoint), getMethodName(joinPoint));

        return proceed;
    }



}
