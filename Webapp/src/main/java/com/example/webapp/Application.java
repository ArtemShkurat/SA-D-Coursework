package com.example.webapp;

import com.example.webapp.api.IPriceGetter;
import com.example.webapp.api.PriceGetter;
import com.example.webapp.model.Database;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IPriceGetter stockService = new PriceGetter();

        while (true) {
            System.out.println("\nEnter a stock symbol to view the latest 10 stock prices (or type 'exit' to quit): ");
            System.out.print("> ");

            String symbol = scanner.next().toUpperCase();
            if (symbol.equals("EXIT")) {
                System.out.println("Goodbye!");
                break;
            }

            Map<String, Database> data = stockService.fetchDatabaseData(symbol);

            if (data.isEmpty()) {
                System.out.println("No data found for " + symbol);
            } else {
                List<String> dates = new ArrayList<>(data.keySet());
                Collections.sort(dates, Collections.reverseOrder());

                System.out.println("\nLatest 10 stock prices for " + symbol + ":\n");
                for (int i = 0; i < Math.min(10, dates.size()); i++) {
                    System.out.println(data.get(dates.get(i)));
                }
            }
        }
        scanner.close();
    }
}