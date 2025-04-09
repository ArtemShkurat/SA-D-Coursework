package com.example.webapp.api;

import com.example.webapp.model.Database;
import java.util.Map;

/**
 * Interface for fetching stock price data.
 *
 * Design Principles Used:
 * - Interface Segregation Principle (ISP): The interface is minimal and focused,
 *   containing only one method (`fetchDatabaseData`), ensuring that implementing
 *   classes are not forced to depend on unused methods.
 * - Dependency Inversion Principle (DIP): The interface defines a high-level
 *   contract for fetching stock data, allowing different implementations to be used
 *   without modifying dependent code.
 */

public interface IPriceGetter {

    /**
     * Fetches stock price data for a given symbol.
     *
     * @param symbol The stock symbol for which data is requested.
     * @return A map containing date-wise stock data, with the date as the key
     *         and a Database object as the value.
     */
    Map<String, Database> fetchDatabaseData(String symbol);
}