package com.example.webapp.model;

/**
 * Represents a stock's historical data for a specific date.
 * Implements the IDatabase interface.
 *
 * Design Principles Used:
 * - Single Responsibility Principle (SRP): This class is only responsible for storing
 *   and providing access to stock data.
 * - Encapsulation: All fields are private, and access is provided via getter methods.
 */
public class Database implements IDatabase {
    
    // Instance variables representing stock attributes
    private String date;  // Date of the stock data
    private double open;  // Opening price
    private double close; // Closing price
    private double low;   // Lowest price of the day
    private double high;  // Highest price of the day
    private long volume;  // Trading volume

    /**
     * Constructor to initialize stock data.
     * 
     * @param date  The date of the stock data.
     * @param open  The opening price of the stock.
     * @param close The closing price of the stock.
     * @param low   The lowest price of the stock.
     * @param high  The highest price of the stock.
     * @param volume The trading volume of the stock.
     */
    public Database(String date, double open, double close, double low, double high, long volume) {
        this.date = date;
        this.open = open;
        this.close = close;
        this.low = low;
        this.high = high;
        this.volume = volume;
    }

    // Getter methods for retrieving stock data
    /**
     * Gets the date of the stock data.
     * 
     * @return The date as a String.
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the opening price of the stock.
     * 
     * @return The opening price.
     */
    public double getOpen() {
        return open;
    }

    /**
     * Gets the closing price of the stock.
     * 
     * @return The closing price.
     */
    public double getClose() {
        return close;
    }

    /**
     * Gets the lowest price of the stock.
     * 
     * @return The lowest price.
     */
    public double getLow() {
        return low;
    }

    /**
     * Gets the highest price of the stock.
     * 
     * @return The highest price.
     */
    public double getHigh() {
        return high;
    }

    /**
     * Gets the trading volume of the stock.
     * 
     * @return The trading volume.
     */
    public long getVolume() {
        return volume;
    }

    /**
     * Returns a formatted string representation of the stock data.
     * 
     * @return A string containing stock details.
     */
    @Override
    public String toString() {
        return String.format("Date: %s\n       Open: %.2f\n       Low: %.2f\n       High: %.2f\n       Close: %.2f\n       Volume: %d",
                date, open, low, high, close, volume);
    }
}
