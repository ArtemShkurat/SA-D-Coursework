package com.example.webapp.model;

public class Database  implements IDatabase {
    private String date;
    private double open;
    private double close;
    private double low;
    private double high;
    private long volume;

    public Database(String date, double open, double close, double low, double high, long volume) {
        this.date = date;
        this.open = open;
        this.close = close;
        this.low = low;
        this.high = high;
        this.volume = volume;
    }

    public String getDate() {
        return date;
    }

    public double getOpen() {
        return open;
    }

    public double getClose() {
        return close;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }

    public long getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return String.format("Date: %s\n       Open: %.2f\n       Low: %.2f\n       High: %.2f\n       Close: %.2f\n       Volume: %d",
                date, open, low, high, close, volume);
    }
}