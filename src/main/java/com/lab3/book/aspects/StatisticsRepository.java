package com.lab3.book.aspects;

import com.lab3.book.aspects.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    @Modifying
    @Query("update Statistics b set b.number = b.number+1  where b.method = ?1 and b.classname = ?2")
    Statistics updateStatistics(String methodName, String className);

    @Query("SELECT sum(s.number) FROM Statistics s")
    int countAllMethodsCalls();


    @Query("SELECT b.method, b.classname, sum(b.number) FROM Statistics b GROUP BY b.method, b.classname")
    List<Object> listOfAllStatisctics();


}


