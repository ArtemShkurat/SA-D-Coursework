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

/**
 * DisplayPOT (Price Over Time) is a servlet responsible for handling POST requests
 * submitted from a form containing two stock symbols. It fetches stock data from
 * an API and forwards the result to a JSP page for display and comparison.
 */
@WebServlet(name = "displayServlet", value = "/display-graph")
public class DisplayPOT extends HttpServlet /* implements IDisplayPOT */ {

    // Service that handles API communication to fetch stock data
    private final IPriceGetter stockService = new PriceGetter();

    /**
     * Handles POST requests for comparing stock data of two companies.
     * Retrieves stock symbols from the request, fetches their data, and forwards
     * the results to a JSP for rendering.
     *
     * @param request  the HttpServletRequest containing the form parameters
     * @param response the HttpServletResponse used to forward to the JSP
     * @throws ServletException if an error occurs during forwarding
     * @throws IOException      if an error occurs while handling input/output
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the stock symbols from form input and convert them to uppercase
        String symbol1 = request.getParameter("company1").toUpperCase();
        String symbol2 = request.getParameter("company2").toUpperCase();

        // Fetch stock data for both companies
        Map<String, Database> data1 = stockService.fetchDatabaseData(symbol1);
        Map<String, Database> data2 = stockService.fetchDatabaseData(symbol2);

        // Pass the data and company symbols as request attributes to be used in the JSP
        request.setAttribute("symbol1", symbol1);
        request.setAttribute("symbol2", symbol2);
        request.setAttribute("stockData1", data1);
        request.setAttribute("stockData2", data2);

        // Forward the request and data to compare.jsp for rendering the comparison chart
        request.getRequestDispatcher("compare.jsp").forward(request, response);
    }
}