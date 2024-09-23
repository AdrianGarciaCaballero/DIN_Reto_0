/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 2dam
 */
public class User {
    
    private String name;
    private String userName;
    private String password;
    private String  dni;
    private Double balance ;

    public User(String name, String userName, String password, String dni, Double balance) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.dni = dni;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", userName=" + userName + ", password=" + password + ", dni=" + dni + ", balance=" + balance + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

  

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    
}