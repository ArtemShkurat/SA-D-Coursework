package com.example.webapp.model;

/**
 * The Customer class represents a user who can register, log in,
 * and interact with the web application.
 * It implements the ICustomerActions interface to allow for future extensibility.
 */
public class Customer implements ICustomerActions {

    // Unique identifier for the customer
    private int id;

    // Username chosen by the customer
    private String username;

    // Customer's email address
    private String email;

    // Customer's password (ideally this would be hashed in a real application)
    private String password;

    /**
     * Constructor to initialize a new Customer object.
     *
     * @param id       Unique ID
     * @param username Username
     * @param email    Email address
     * @param password Password
     */
    public Customer(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter and setter methods for customer ID
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    // Getter and setter methods for username
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    // Getter and setter methods for email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Getter and setter methods for password
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    /**
     * Returns a string representation of the Customer object.
     * Useful for debugging and logging.
     */
    @Override
    public String toString() {
        return String.format("ID: %d\n       Username: %s\n       Email: %s\n       Password: %s",
                id, username, email, password);
    }
}