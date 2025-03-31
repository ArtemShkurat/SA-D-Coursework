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

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final IPriceGetter stockService = new PriceGetter();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stockSymbol = request.getParameter("company1");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (stockSymbol == null || stockSymbol.isEmpty()) {
            out.println("<h2>Please enter a valid stock symbol.</h2>");
            return;
        }

        Map<String, Database> stockData = stockService.fetchDatabaseData(stockSymbol.toUpperCase());

        out.println("<html><body>");
        out.println("<h1>Stock Data for " + stockSymbol.toUpperCase() + "</h1>");

        if (stockData.isEmpty()) {
            out.println("<p>No data found for " + stockSymbol.toUpperCase() + "</p>");
        } else {
            out.println("<table border='1'><tr><th>Date</th><th>Open</th><th>Low</th><th>High</th><th>Close</th><th>Volume</th></tr>");
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