package model;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    private final List<Item> allItems;

    //EFFECTS: initialises allItems to NULL
    public Collection() {
        this.allItems = new ArrayList<>();
    }

    //REQUIRES: Item should not already be present in allItems
    //MODIFIES: this
    //EFFECTS: Item will be added to allItems
    public void insertItem(Item item) {
        if (!allItems.contains(item)) {
            this.allItems.add(item);
        } else {
            System.out.println("ERROR! Item already exists in the list");
        }
    }

    //MODIFIES: this
    //EFFECTS: removes the given Item from allItems
    public void removeItem(String itemName) {
        for (Item i : allItems) {
            if (i.getName().equals(itemName)) {
                allItems.remove(i);
                return;
            }
        }
        System.out.println("Item not found!");
    }

    // EFFECTS: Returns true if Item i is in allItems
    // and false otherwise
    public boolean contains(Item i) {
        return allItems.contains(i);
    }


    //EFFECTS: Returns true if Item with name n is present in allItems
    public boolean containsWithName(String n) {
        for (Item i : this.allItems) {
            if (i.getName().equals(n)) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: Returns the number of items in allItems
    public int size() {
        return allItems.size();
    }

    //EFFECTS: adds a horizontal line of to separate rows of a table
    private void addLine() {
        System.out.print("+-------+---------------------+---------------------+--------------------------------------"
                + "-------------+--------+----------+----------------+-------+-----------+-----------+----------+\n");
    }


    //EFFECTS: Displays all the products
    public void displayAllItems() {
        addLine();
        System.out.printf("| %-6s| %-20s| %-20s| %-50s| %-7s| %-9s| %-15s| %-6s| %-10s| %-10s| %-9s|\n",
                "SNo.", "Name", "Brand", "Description", "Price", "Category", "Type", "Size",
                "Colour", "Discount", "inStock");

        addLine();
        for (int i = 0; i < allItems.size(); i++) {
            System.out.printf("| %-6d", i + 1);
            allItems.get(i).showItem();
        }
        addLine();
    }

}
