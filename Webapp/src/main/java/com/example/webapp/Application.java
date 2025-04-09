package com.example.webapp;

import com.example.webapp.api.IPriceGetter;
import com.example.webapp.api.PriceGetter;
import com.example.webapp.model.Database;

import java.util.*;

/**
 * Main application class that provides an interactive console-based interface
 * for fetching and displaying the latest stock prices using the Alpha Vantage API.
 *
 * Design Principles Used:
 * - Single Responsibility Principle (SRP): This class is responsible for user interaction and data presentation,
 *   while the data fetching logic is delegated to the IPriceGetter interface implementation.
 * - Dependency Inversion Principle (DIP): The class depends on the IPriceGetter interface rather than a concrete implementation,
 *   allowing flexibility and easier extension in the future.
 */
public class Application {
    public static void main(String[] args) {
        // Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Dependency injection: Using an instance of PriceGetter through the IPriceGetter interface
        IPriceGetter stockService = new PriceGetter();

        // Loop to repeatedly prompt the user for stock symbols until they choose to exit
        while (true) {
            System.out.println("\nEnter a stock symbol to view the latest 10 stock prices (or type 'exit' to quit): ");
            System.out.print("> ");

            // Read user input, convert it to uppercase to match stock symbols
            String symbol = scanner.next().toUpperCase();
            if (symbol.equals("EXIT")) {
                System.out.println("Goodbye!");
                break; // Exit the loop if the user types 'exit'
            }

            // Fetch stock data using the IPriceGetter service
            Map<String, Database> data = stockService.fetchDatabaseData(symbol);

            // Handle case where no data is available for the given stock symbol
            if (data.isEmpty()) {
                System.out.println("No data found for " + symbol);
            } else {
                // Sort dates in descending order to get the latest stock prices
                List<String> dates = new ArrayList<>(data.keySet());
                Collections.sort(dates, Collections.reverseOrder());

                // Display the latest 10 stock prices
                System.out.println("\nLatest 10 stock prices for " + symbol + ":\n");
                for (int i = 0; i < Math.min(10, dates.size()); i++) {
                    System.out.println(data.get(dates.get(i))); // Print stock data using Database's toString() method
                }
            }
        }
        // Close the scanner to free system resources
        scanner.close();
    }
}