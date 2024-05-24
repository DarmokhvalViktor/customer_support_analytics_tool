package com.darmokhval.models;

import java.time.LocalDate;

/**
 * Class to describe "waiting timeline" state and behavior
 */
public class Timeline extends DefaultEntity{
    private LocalDate date;
    private int waitingTime;

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    @Override
    public String toString() {
        return "Timeline{" +
                "date=" + date +
                ", waitingTime=" + waitingTime +
                "} " + super.toString();
    }
}
