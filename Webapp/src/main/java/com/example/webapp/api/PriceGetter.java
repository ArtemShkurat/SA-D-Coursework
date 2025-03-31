package com.example.webapp.api;

import com.example.webapp.model.Database;
import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class PriceGetter implements com.example.webapp.api.IPriceGetter {

    private static final String API_KEY = "HKZUY1I50STQPIR4";
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=%s";

    @Override
    public Map<String, Database> fetchDatabaseData(String symbol) {
        Map<String, Database> result = new TreeMap<>();
        try {
            String urlString = String.format(BASE_URL, symbol, API_KEY);
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonObject timeSeries = jsonObject.getAsJsonObject("Time Series (Daily)");

            for (Map.Entry<String, JsonElement> entry : timeSeries.entrySet()) {
                String date = entry.getKey();
                JsonObject dailyData = entry.getValue().getAsJsonObject();
                double open = dailyData.get("1. open").getAsDouble();
                double high = dailyData.get("2. high").getAsDouble();
                double low = dailyData.get("3. low").getAsDouble();
                double close = dailyData.get("4. close").getAsDouble();
                long volume = dailyData.get("5. volume").getAsLong();

                result.put(date, new Database(date, open, close, low, high, volume));
            }
        } catch (Exception e) {
            System.out.println("Error fetching stock data: " + e.getMessage());
        }
        return result;
    }
}