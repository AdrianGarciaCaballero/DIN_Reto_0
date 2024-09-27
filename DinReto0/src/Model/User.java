/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Class representing a User in the system.
 * Provides user details such as name, username, password, DNI, and balance.
 * Contains getter and setter methods to access and modify user information.
 * 
 * @author Adrian & Omar
 * @version 1.0
 */
public class User {
    
    // User's full name
    private String name;
    
    // User's unique username
    private String userName;
    
    // User's password for authentication
    private String password;
    
    // User's DNI (identification number)
    private String dni;
    
    // User's current account balance
    private Double balance;

    /**
     * Constructor to initialize a User with the specified attributes.
     * 
     * @param name the name of the user
     * @param userName the username of the user
     * @param password the password of the user
     * @param dni the DNI of the user
     * @param balance the account balance of the user
     */
    public User(String name, String userName, String password, String dni, Double balance) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.dni = dni;
        this.balance = balance;
    }

    /**
     * Provides a string representation of the User object.
     * 
     * @return a string containing all user details
     */
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", userName=" + userName + ", password=" + password + ", dni=" + dni + ", balance=" + balance + '}';
    }

    /**
     * Gets the name of the user.
     * 
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the username of the user.
     * 
     * @return the user's username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the user.
     * 
     * @param userName the username to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password of the user.
     * 
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the DNI of the user.
     * 
     * @return the user's DNI
     */
    public String getDni() {
        return dni;
    }

    /**
     * Sets the DNI of the user.
     * 
     * @param dni the DNI to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Gets the balance of the user's account.
     * 
     * @return the user's balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the user's account.
     * 
     * @param balance the balance to set
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
