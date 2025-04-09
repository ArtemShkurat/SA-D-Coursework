package com.example.webapp;

import com.example.webapp.model.Customer;
import com.example.webapp.model.ICustomerActions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Signup servlet handles POST requests for user registration.
 * It creates and stores a new customer based on submitted form data.
 */
@WebServlet(name = "signupServlet", value = "/signup")
public class Signup extends HttpServlet {

    // Static in-memory list to simulate a user database (temporary storage)
    public static final List<Customer> registeredUsers = new ArrayList<>();

    // Simple auto-increment counter for assigning unique user IDs
    private static int idCounter = 1;

    /**
     * Handles POST requests to register a new user.
     * Extracts form input, creates a new Customer object, and stores it in memory.
     *
     * @param request  the HttpServletRequest containing form fields
     * @param response the HttpServletResponse used to send confirmation
     * @throws ServletException if a servlet-related error occurs
     * @throws IOException      if an input/output error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get registration form values from the request
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a new Customer object with auto-incremented ID
        Customer newCustomer = new Customer(idCounter++, username, email, password);

        // Store the new customer in the in-memory list
        registeredUsers.add(newCustomer);

        // Display confirmation message and provide a link to login
        response.setContentType("text/html");
        response.getWriter().println("<h2>Registration successful!</h2>");
        response.getWriter().println("<form action=\"login.jsp\" method=\"get\">");
        response.getWriter().println("<button type=\"submit\">Go to Login</button>");
        response.getWriter().println("</form>");
    }
}