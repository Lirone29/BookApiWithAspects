package com.lab3.book.aspects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.lab3.book.models.Book;

import java.io.Serializable;
import java.util.List;

@JacksonXmlRootElement(localName = "StatisticsList")
public class StatisticsList implements Serializable {

    private static final long serialVersionUID = 1L;

    @JacksonXmlProperty(localName = "Statistics")
    @JacksonXmlElementWrapper(useWrapping = false)
    protected List<Statistics> statistics = null;

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public List<Statistics> getStatisticsPercentage(int number) {
        List<Statistics> percentageList = this.statistics;
        for(int i = 0; i < percentageList.size(); i++){
        percentageList.get(i).setNumber( (int) ( ((double) percentageList.get(i).getNumber()/ (double) number)*100));
    }
        return statistics;
    }

    public int getSize(){
        return statistics.size();
    }

    public Statistics getStatistic(int i){
        return statistics.get(i);
    }
}
