package com.lab3.book.aspects;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab3.book.controllers.BookApiController;
import com.lab3.book.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    private static final Logger log = LoggerFactory.getLogger(BookApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final Book newestBook;

    @org.springframework.beans.factory.annotation.Autowired
    public StatisticsController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.newestBook = null;
    }

    @RequestMapping(value = "/normal", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<Statistics>> getAllStatistics() {
        System.out.println("In stats controller");

        return ResponseEntity.ok(statisticsService.getAllStatistic());
    }


    @RequestMapping(value = "/normal/count", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<Integer> countAllMethodsCalls() {
        return ResponseEntity.ok(statisticsService.countAllMethodsCalls());
    }

    @RequestMapping(value = "/percentage", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<StatisticsList> getAllStatisticsInPercentage() {

        int numberOfcalls = statisticsService.countAllMethodsCalls();

        StatisticsList statisticsList = new StatisticsList();
        statisticsList.setStatistics(statisticsService.getAllStatistic());
        statisticsList.getStatisticsPercentage(numberOfcalls);
        return ResponseEntity.ok(statisticsList);

    }

    @RequestMapping(value = "/newestBook", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<Book> getNewestBook() {
        return ResponseEntity.ok(statisticsService.getNewestBook());
    }

    @RequestMapping(value = "/newestYear", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<Integer> getNewestYear() {
        return ResponseEntity.ok(statisticsService.getNewestBook().getYear().intValue());
    }

    @RequestMapping(value = "/oldestBook", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<Book> getOldestBook() {
        return ResponseEntity.ok(statisticsService.getOldestBook());
    }

    @RequestMapping(value = "/oldestYear", produces = { "application/xml", "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<Integer> getOldestYear() {
        return ResponseEntity.ok(statisticsService.getOldestBook().getYear().intValue());
    }

}
