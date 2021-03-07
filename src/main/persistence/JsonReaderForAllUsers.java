package persistence;

import model.AllUsers;
import model.Item;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class JsonReaderForAllUsers extends JsonReader {
    public JsonReaderForAllUsers(String source) {
        super(source);
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public AllUsers read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseAllUsers(jsonObject);
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private AllUsers parseAllUsers(JSONObject jsonObject) {
        AllUsers users = new AllUsers();
        addUsers(users, jsonObject);
        return users;
    }

    // MODIFIES: users
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addUsers(AllUsers users, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("users");
        for (Object json : jsonArray) {
            JSONObject nextUser = (JSONObject) json;
            addUser(users, nextUser);
        }
    }

    // MODIFIES: allStudents
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addUser(AllUsers allUsers, JSONObject jsonObject) {
        String firstName = jsonObject.getString("firstName");
        String lastName = jsonObject.getString("lastName");
        String username = jsonObject.getString("username");
        String emailId = jsonObject.getString("emailId");
        String password = jsonObject.getString("password");
        String mobileNumber = jsonObject.getString("mobileNumber");
        int age = jsonObject.getInt("age");
        String gender = jsonObject.getString("gender");
        ArrayList<Item> wishlist = parseWishlist(jsonObject);
        ArrayList<Item> cart = parseCart(jsonObject);
        ArrayList<Item> orderHistory = parseOrderHistory(jsonObject);
        User user = new User(firstName, lastName, username, emailId, password, age);
        user.setMobileNumber(mobileNumber);
        user.setGender(gender);
        user.setCart(cart);
        user.setWishlist(wishlist);
        user.setOrderHistory(orderHistory);
        allUsers.insertUser(user);
    }

    private ArrayList<Item> parseWishlist(JSONObject jsonObject) {
        ArrayList<Item> wishlist = new ArrayList<>();
        addItemsToWishlist(wishlist, jsonObject);
        return wishlist;
    }

    private void addItemsToWishlist(ArrayList<Item> wishlist, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("wishlist");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(wishlist, nextItem);
        }
    }

    private ArrayList<Item> parseCart(JSONObject jsonObject) {
        ArrayList<Item> cart = new ArrayList<>();
        addItemsToCart(cart, jsonObject);
        return cart;
    }

    private void addItemsToCart(ArrayList<Item> cart, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("cart");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(cart, nextItem);
        }
    }

    private ArrayList<Item> parseOrderHistory(JSONObject jsonObject) {
        ArrayList<model.Item> orderHistory = new ArrayList<>();
        addItemsToOrderHistory(orderHistory, jsonObject);
        return orderHistory;
    }

    private void addItemsToOrderHistory(ArrayList<Item> orderHistory, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("orderHistory");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(orderHistory, nextItem);
        }
    }

    private void addItem(ArrayList<Item> itemArrayList, JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        String name = jsonObject.getString("name");
        String brand = jsonObject.getString("brand");
        String description = jsonObject.getString("description");
        float price = jsonObject.getFloat("price");
        String category = jsonObject.getString("category");
        String size = jsonObject.getString("size");
        String colour = jsonObject.getString("colour");
        float discount = jsonObject.getFloat("discount");
        boolean inStock = jsonObject.getBoolean("inStock");
        Item item = new Item(id, name, brand, description, price, category, size);
        item.setDiscount(discount);
        item.setColour(colour);
        item.setInStock(inStock);
        itemArrayList.add(item);
    }
}
