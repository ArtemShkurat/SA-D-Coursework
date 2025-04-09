package com.example.webapp;

import com.example.webapp.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

/**
 * The Login servlet handles POST requests for user authentication.
 * It checks if the provided username/email and password match any registered user.
 */
@WebServlet(name = "loginServlet", value = "/login")
public class Login extends HttpServlet {

    /**
     * Handles POST requests from the login form.
     * Validates the user's credentials and provides feedback.
     *
     * @param request  the HttpServletRequest containing form data
     * @param response the HttpServletResponse used to send HTML feedback
     * @throws ServletException if a servlet error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve login input and password from form
        String loginInput = request.getParameter("loginInput");
        String password = request.getParameter("password");

        // Access the list of registered users (stored in memory via Signup class)
        List<Customer> users = Signup.registeredUsers;

        // Check if any user matches the provided username/email and password
        boolean match = users.stream().anyMatch(user ->
                (user.getUsername().equalsIgnoreCase(loginInput) || user.getEmail().equalsIgnoreCase(loginInput))
                        && user.getPassword().equals(password)
        );

        // Set response type to HTML
        response.setContentType("text/html");

        if (match) {
            // If login is successful, show confirmation and a button to go to main menu
            response.getWriter().println("<h2>Login successful!</h2>");
            response.getWriter().println("<form action=\"index.jsp\" method=\"get\">");
            response.getWriter().println("<button type=\"submit\">Go to Main Menu</button>");
            response.getWriter().println("</form>");
        } else {
            // If login fails, inform the user and offer a retry link
            response.getWriter().println("<h2>Login failed! Invalid credentials.</h2><a href=\"login.jsp\">Try Again</a>");
        }
    }
}