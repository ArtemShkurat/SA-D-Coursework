package com.example.webapp.model;

/**
 * ICustomerActions defines a contract for customer-related behavior.
 * This interface allows classes like Customer to guarantee they provide
 * a custom string representation, and can be expanded with more customer-related actions in the future.
 */
public interface ICustomerActions {

    /**
     * Provides a string representation of the implementing class.
     * Typically overridden to include meaningful customer data for debugging or display purposes.
     *
     * @return a string describing the customer
     */
    String toString();
}