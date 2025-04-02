package com.example.webapp.model;

/**
 * Interface for representing a database entity.
 * 
 * Design Principles Used:
 * - Interface Segregation Principle (ISP): This interface is minimal and focused,
 *   only requiring the implementation of the toString() method.
 * - Dependency Inversion Principle (DIP): Higher-level modules depend on this
 *   abstraction rather than concrete implementations.
 */
public interface IDatabase {
    
    /**
     * Returns a string representation of the implementing class.
     * 
     * @return A formatted string containing object details.
     */
    String toString();
}
