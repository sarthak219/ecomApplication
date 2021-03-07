package model;

import org.json.JSONObject;
import persistence.Writable;

//represents an item with name, brand, price, size, etc
public class Item implements Writable {
    private int id;
    private String name;
    private String brand;
    private String description;
    private float price;
    private String category;
    private String size;
    private String colour;
    private float discount;
    private boolean inStock;

    public Item(int id, String name, String brand, String description, float price, String category, String size) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.category = category;
        this.size = size;
    }

    //EFFECTS: constructs a new Item
    public Item() {
        this.id = 0;
        this.name = null;
        this.brand = null;
        this.description = null;
        this.price = 0;
        this.category = null;
        this.size = null;
        this.colour = null;
        this.discount = 0;
        this.inStock = true;
    }

    //EFFECTS: returns the product name
    public String getName() {
        return this.name;
    }

    //EFFECTS: returns the product id
    public int getId() {
        return this.id;
    }

    //EFFECTS: returns inStock
    public boolean getInStock() {
        return inStock;
    }

    //EFFECTS: returns the price
    public float getPrice() {
        return this.price;
    }

    //EFFECTS: returns the discount
    public float getDiscount() {
        return this.discount;
    }

    //MODIFIES: this
    //EFFECTS: sets the the product id to the given value
    public void setId(int id) {
        this.id = id;
    }

    //MODIFIES: this
    //EFFECTS: sets the price to the given price
    public void setPrice(float price) {
        this.price = price;
    }

    //MODIFIES: this
    //EFFECTS: sets name to the given string
    public void setName(String name) {
        this.name = name;
    }

    //MODIFIES: this
    //EFFECTS: sets brand to the given string
    public void setBrand(String brand) {
        this.brand = brand;
    }

    //MODIFIES: this
    //EFFECTS: sets the description to the given description
    public void setDescription(String description) {
        this.description = description;
    }

    //MODIFIES: this
    //EFFECTS: sets the gender to the given gender
    public void setCategory(String category) {
        this.category = category;
    }

    //MODIFIES: this
    //EFFECTS: sets the size to the given size
    public void setSize(String size) {
        this.size = size;
    }

    //MODIFIES: this
    //EFFECTS: sets the colour to the given colour
    public void setColour(String colour) {
        this.colour = colour;
    }

    //MODIFIES: this
    //EFFECTS: sets the discount to the given discount
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    //MODIFIES: this
    //EFFECTS: sets the status of inStock to the given status of inStock
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    //EFFECTS: displays all the fields of the Item in a line separated by "|"
    public void showItem() {
        System.out.printf("| %-6d| %-20s| %-20s| %-50s| %-13.2f| %-9s| %-6s| %-10s| %-13.2f| %-9s|\n",
                this.id, this.name, this.brand, this.description, this.price, this.category,
                this.size, this.colour, this.discount, this.inStock);
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("name", this.name);
        json.put("brand", this.brand);
        json.put("description", this.description);
        json.put("price", this.price);
        json.put("category", this.category);
        json.put("size", this.size);
        json.put("colour", this.colour);
        json.put("discount", this.discount);
        json.put("inStock", this.inStock);
        return json;
    }
}