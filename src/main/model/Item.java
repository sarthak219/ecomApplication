package model;

public class Item {
    private String name;
    private String brand;
    private String description;
    private int price;
    private String category;
    private String type;
    private String size;
    private String colour;
    private int discount;
    private boolean inStock;

    //EFFECTS: constructor
    public Item() {
        this.name = null;
        this.brand = null;
        this.description = null;
        this.price = 0;
        this.category = null;
        this.type = null;
        this.size = null;
        this.colour = null;
        this.discount = 0;
        this.inStock = true;
    }

    public String getName() {
        return this.name;
    }

    //MODIFIES: this
    //EFFECTS: sets the price to the given price
    public void setPrice(int price) {
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
    //EFFECTS: sets the category to the given category
    public void setType(String type) {
        this.type = type;
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
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    //MODIFIES: this
    //EFFECTS: sets the status of inStock to the given status of inStock
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    //EFFECTS: displays all the fields of the Item
    public void showItem() {
        System.out.printf("| %-20s| %-20s| %-50s| %-7d| %-9s| %-15s| %-6s| %-10s| %-10d| %-9s|\n",
                this.name, this.brand, this.description, this.price, this.category, this.type, this.size,
                this.colour, this.discount, this.inStock);
    }
}