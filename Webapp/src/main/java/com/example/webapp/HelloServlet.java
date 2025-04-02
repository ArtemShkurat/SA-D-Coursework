package com.example.webapp;

import com.example.webapp.api.IPriceGetter;
import com.example.webapp.api.PriceGetter;
import com.example.webapp.model.Database;
import java.io.IOException;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.PrintWriter;

/**
 * A servlet that handles HTTP POST requests to fetch and display stock data.
 *
 * Uses the Alpha Vantage API through the PriceGetter service to retrieve stock market information.
 * Implements SRP (Single Responsibility Principle) by separating HTTP handling logic from stock retrieval.
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    // Stock data retrieval service implementing IPriceGetter
    private final IPriceGetter stockService = new PriceGetter();

    /**
     * Handles HTTP POST requests to fetch stock data based on user input.
     *
     * @param request  The HTTP request containing user input.
     * @param response The HTTP response to display stock data.
     * @throws ServletException If a servlet-specific error occurs.
     * @throws IOException If an I/O error occurs.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the stock symbol from the request parameter
        String stockSymbol = request.getParameter("company1");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Validate user input for stock symbol
        if (stockSymbol == null || stockSymbol.isEmpty()) {
            out.println("<h2>Please enter a valid stock symbol.</h2>");
            return;
        }

        // Fetch stock data from the service
        Map<String, Database> stockData = stockService.fetchDatabaseData(stockSymbol.toUpperCase());

        // Generate HTML response with stock data
        out.println("<html><body>");
        out.println("<h1>Stock Data for " + stockSymbol.toUpperCase() + "</h1>");

        if (stockData.isEmpty()) {
            out.println("<p>No data found for " + stockSymbol.toUpperCase() + "</p>");
        } else {
            out.println("<table border='1'><tr><th>Date</th><th>Open</th><th>Low</th><th>High</th><th>Close</th><th>Volume</th></tr>");
            // Display the latest 10 stock entries in a table
            stockData.entrySet().stream().limit(10).forEach(entry -> {
                Database stock = entry.getValue();
                out.println("<tr><td>" + stock.getDate() + "</td><td>" + stock.getOpen() + "</td><td>" + stock.getLow() +
                        "</td><td>" + stock.getHigh() + "</td><td>" + stock.getClose() + "</td><td>" + stock.getVolume() + "</td></tr>");
            });
            out.println("</table>");
        }
        out.println("</body></html>");
    }
}
