package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// represents a user account with his/her credentials, cart, wishlist and order history
public class User implements Writable {
    private String firstName;
    private String lastName;
    protected String username;
    private String emailId;
    protected String password;
    private String mobileNumber;
    private int age;
    private String gender;
    private ArrayList<Item> wishlist;
    private ArrayList<Item> cart;
    private ArrayList<Item> orderHistory;

    public User() {
        this.wishlist = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }

    public User(String firstName, String lastName, String username, String emailId, String password, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.emailId = emailId;
        this.password = password;
        this.age = age;
        this.wishlist = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }

    public void makeGuestUser() {
        this.firstName = "guest";
        this.lastName = "";
        this.username = "Guest@123";
        this.emailId = "";
        this.password = "";
        this.mobileNumber = "0000000000";
        this.age = 0;
        this.gender = "";
        this.wishlist = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
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

    //REQUIRES: age > 0
    //MODIFIES: this
    //EFFECTS: sets the age to the given value
    public void setAge(int age) {
        this.age = age;
    }

    //MODIFIES: this
    //EFFECTS: sets the cart to the given value
    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }

    //MODIFIES: this
    //EFFECTS: sets the wishlist to the given value
    public void setWishlist(ArrayList<Item> wishlist) {
        this.wishlist = wishlist;
    }

    //MODIFIES: this
    //EFFECTS: sets the orderHistory to the given value
    public void setOrderHistory(ArrayList<Item> orderHistory) {
        this.orderHistory = orderHistory;
    }

    //REQUIRES: gender is one of "male", "female" or "other"
    //MODIFIES: this
    //EFFECTS: sets the gender to the given string
    public void setGender(String gender) {
        this.gender = gender;
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

    //EFFECTS: returns last name of the current User
    public String getLastName() {
        return lastName;
    }

    //EFFECTS: returns email of the current User
    public String getEmailId() {
        return emailId;
    }

    //EFFECTS: returns mobile number of the current User
    public String getMobileNumber() {
        return mobileNumber;
    }

    //EFFECTS: returns age of the current User
    public int getAge() {
        return age;
    }

    //EFFECTS: returns gender of the current User
    public String getGender() {
        return gender;
    }

    //EFFECTS: returns cart
    public ArrayList<Item> getCart() {
        return this.cart;
    }

    //EFFECTS: returns wishlist
    public ArrayList<Item> getWishlist() {
        return this.wishlist;
    }

    //EFFECTS: returns order history
    public ArrayList<Item> getOrderHistory() {
        return this.orderHistory;
    }

    //EFFECTS: shows the user's credentials in a row separated by "|"
    public void showUser() {
        System.out.printf("| %-20s|  %-20s| %-20s| %-50s| %-20s| %-15s| %-5s| %-10s|\n",
                this.firstName, this.lastName, this.username, this.emailId, this.password,
                this.mobileNumber, this.age, this.gender);
    }

    //REQUIRES: item shouldn't already be present in wishlist
    //MODIFIES: this
    //EFFECTS: adds the item to wishlist
    public void addItemToWishlist(Item item) {
        this.wishlist.add(item);
    }

    //REQUIRES: item shouldn't already be present in cart and should be in stock
    //MODIFIES: this
    //EFFECTS: adds the item to cart
    public void addItemToCart(Item item) {
        this.cart.add(item);
    }

    //MODIFIES: this
    //EFFECTS: adds the item to order history
    public void addItemToOrderHistory(Item item) {
        this.orderHistory.add(item);
    }


    //MODIFIES: this
    //EFFECTS: removes the item from wishlist
    public void removeItemsFromWishlist(Item item) {
        this.wishlist.remove(item);
    }

    //MODIFIES: this
    //EFFECTS: removes the item from cart
    public void removeItemsFromCart(Item item) {
        this.cart.remove(item);
    }


    //EFFECTS: returns true if Item is present in the current user's cart
    //         false otherwise
    public boolean inWishlist(Item item) {
        return this.wishlist.contains(item);
    }


    //EFFECTS: returns true if item with the given id exists in wishlist
    public boolean wishListContainsItemWithId(int id) {
        for (Item item : this.wishlist) {
            if (item.getId() == id) {
                return true;
            }
        }
        return false;
    }

    //EFFECTS: returns true if Item is present in the current user's cart
    //         false otherwise
    public boolean inCart(Item item) {
        return this.cart.contains(item);
    }

    //EFFECTS: returns true if item with the given id exists in cart
    public boolean cartContainsItemWithId(int id) {
        for (Item item : this.cart) {
            if (item.getId() == id) {
                return true;
            }
        }
        return false;
    }

    //EFFECTS: returns true if item with the given id exists in orderHistory
    public boolean orderHistoryContainsItemWithId(int id) {
        for (Item item : this.orderHistory) {
            if (item.getId() == id) {
                return true;
            }
        }
        return false;
    }

    //EFFECTS: return the total payable amount after subtracting discount
    public float totalBill() {
        float bill = 0;
        for (Item item : this.cart) {
            float priceAfterDiscount = item.getPrice() - item.getPrice() * item.getDiscount() / 100;
            bill += priceAfterDiscount;
        }
        return bill;
    }

    //REQUIRES: item.getInStock() must be true
    //MODIFIES: this, item
    //EFFECTS: orders the given item, removes it from cart and wishlist if present,
    //         changes item.inStock to false everywhere
    public void orderItem(Item item) {
        item.setInStock(false);
        this.orderHistory.add(item);
        removeItemsFromCart(item);
        removeItemsFromWishlist(item);
        for (Item product : orderHistory) {
            if (item.getId() == product.getId()) {
                product.setInStock(false);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: sets all occurrences of item.inStock to true in Order history
    public void returnItem(Item item) {
        for (Item product : orderHistory) {
            if (product.getId() == item.getId()) {
                product.setInStock(true);
            }
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("firstName", this.firstName);
        json.put("lastName", this.lastName);
        json.put("username", this.username);
        json.put("emailId", this.emailId);
        json.put("password", this.password);
        json.put("mobileNumber", this.mobileNumber);
        json.put("age", this.age);
        json.put("gender", this.gender);
        json.put("wishlist", wishlistToJson());
        json.put("cart", cartToJson());
        json.put("orderHistory", orderHistoryToJson());
        return json;
    }

    // EFFECTS: returns items in this wishlist as a JSON array
    private JSONArray wishlistToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Item item : this.wishlist) {
            jsonArray.put(item.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns items in this cart as a JSON array
    private JSONArray cartToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Item item : this.cart) {
            jsonArray.put(item.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns items in this orderHistory as a JSON array
    private JSONArray orderHistoryToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Item item : this.orderHistory) {
            jsonArray.put(item.toJson());
        }
        return jsonArray;
    }
}
