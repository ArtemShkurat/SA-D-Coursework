package com.example.webapp.api;

import com.example.webapp.model.Database;
import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.util.*;

// Class responsible for fetching stock price data from the Alpha Vantage API
public class PriceGetter implements com.example.webapp.api.IPriceGetter {

    // API key for accessing the Alpha Vantage API
    private static final String API_KEY = "HKZUY1I50STQPIR4";
    
    // Base URL template for fetching stock data, with placeholders for symbol and API key
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=%s";

    // Method to fetch stock price data and return it as a map with date as key and Database object as value
    @Override
    public Map<String, Database> fetchDatabaseData(String symbol) {
        Map<String, Database> result = new TreeMap<>(); // TreeMap to store data in sorted order by date
        try {
            // Format the URL with the given stock symbol and API key
            String urlString = String.format(BASE_URL, symbol, API_KEY);
            URL url = new URL(urlString);

            // Open HTTP connection and set request method to GET
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response from the API
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            // Store the response in a StringBuilder
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close(); // Close the reader

            // Parse the response JSON
            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonObject timeSeries = jsonObject.getAsJsonObject("Time Series (Daily)");

            // Iterate through the JSON data and extract stock details
            for (Map.Entry<String, JsonElement> entry : timeSeries.entrySet()) {
                String date = entry.getKey(); // Get the date
                JsonObject dailyData = entry.getValue().getAsJsonObject(); // Get daily stock data
                
                // Extract stock values from JSON
                double open = dailyData.get("1. open").getAsDouble();
                double high = dailyData.get("2. high").getAsDouble();
                double low = dailyData.get("3. low").getAsDouble();
                double close = dailyData.get("4. close").getAsDouble();
                long volume = dailyData.get("5. volume").getAsLong();
                
                // Store the extracted data in a Database object and add it to the result map
                result.put(date, new Database(date, open, close, low, high, volume));
            }
        } catch (Exception e) {
            // Handle any errors that occur during the API request
            System.out.println("Error fetching stock data: " + e.getMessage());
        }
        return result; // Return the fetched data
    }
}
