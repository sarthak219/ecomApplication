package model;

import model.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    Scanner sc = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private String username;
    private String emailId;
    private String password;
    private String mobileNumber;
    private int age;
    private String gender;
    private ArrayList<Item> wishlist;
    private ArrayList<Item> cart;
    private ArrayList<Item> recentOrders;

    public User() {
        this.firstName = null;
        this.lastName = null;
        this.username = null;
        this.emailId = null;
        this.password = null;
        this.mobileNumber = "0000000000";
        this.age = 0;
        this.gender = null;
        this.wishlist = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.recentOrders = new ArrayList<>();
    }

    public void makeGuestUser() {
        this.firstName = "guest";
        this.lastName = null;
        this.username = "Guest@123";
        this.emailId = null;
        this.password = null;
        this.mobileNumber = "0000000000";
        this.age = 0;
        this.gender = null;
        this.wishlist = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.recentOrders = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: sets the first name to the given string
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //MODIFIES: this
    //EFFECTS: sets the last name to the given string
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //MODIFIES: this
    //EFFECTS: sets the username to the given string
    public void setUsername(String username) {
        this.username = username;
    }

    //MODIFIES: this
    //EFFECTS: sets the email ID to the given string
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    //MODIFIES: this
    //EFFECTS: sets the password to the given string
    public void setPassword(String password) {
        this.password = password;
    }

    //MODIFIES: this
    //EFFECTS: sets the mobile number to the given number
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    //MODIFIES: this
    //EFFECTS: sets the age to the given value
    public void setAge(int age) {
        this.age = age;
    }

    //MODIFIES: this
    //EFFECTS: sets the gender to the given string
    public void setGender(String gender) {
        this.gender = gender;
    }

    //MODIFIES: this
    //EFFECTS: sets the wishlist to the given ArrayList
    public void setWishlist(ArrayList<Item> wishlist) {
        this.wishlist = wishlist;
    }

    //MODIFIES: this
    //EFFECTS: sets the wishlist to the given ArrayList
    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }


    //MODIFIES: this
    //EFFECTS: sets the wishlist to the given ArrayList
    public void setRecentOrders(ArrayList<Item> recentOrders) {
        this.recentOrders = recentOrders;
    }


    //EFFECTS: returns username
    public String getUsername() {
        return this.username;
    }

    //EFFECTS: returns the password
    public String getPassword() {
        return this.password;
    }

    //EFFECTS: returns first name of the current User
    public String getFirstName() {
        return this.firstName;
    }

    public void showUser() {
        System.out.printf("| %-6s| %-20s|  %-20s| %-20s| %-50s| %-20s| %-15s| %-5s| %-10s|\n",
                this.firstName, this.lastName, this.username, this.emailId, this.password,
                this.mobileNumber, this.age, this.gender);
    }

}
