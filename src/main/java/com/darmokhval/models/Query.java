package com.darmokhval.models;

import java.time.LocalDate;

/**
 * Class to describe "query line" state and behavior
 */
public class Query extends DefaultEntity{
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int lineCount;

    @Override
    public void setDate(LocalDate date) {
        throw new UnsupportedOperationException("Operation is not supported, 'SetDate'");
    }

    @Override
    public void setWaitingTime(int waitingTime) {
        throw new UnsupportedOperationException("Operation is not supported, 'SetWaitingTime'");
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    @Override
    public String toString() {
        return "Query{" +
                "dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", lineCount=" + lineCount +
                "} " + super.toString();
    }
}
