package model;

import java.util.ArrayList;

public class Collection {
    private final ArrayList<Item> allItems;

    //EFFECTS: initialises allItems to NULL
    public Collection() {
        this.allItems = new ArrayList<>();
    }

    //EFFECTS: returns allItems
    public ArrayList<Item> getAllProducts() {
        return allItems;
    }

    //REQUIRES: Item with same id should not already be present in allItems
    //MODIFIES: this
    //EFFECTS: Item will be added to allItems
    public void insertItem(Item item) {
        this.allItems.add(item);
        System.out.println("Item added successfully!");
    }

    //MODIFIES: this
    //EFFECTS: removes the given Item from allItems
    public void removeItem(String itemName) {
        for (Item i : allItems) {
            if (i.getName().equals(itemName)) {
                allItems.remove(i);
                System.out.println("Item removed successfully!");
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

    //EFFECTS: Returns true if Item with name n is present in allItems
    public boolean containsWithId(int id) {
        for (Item i : this.allItems) {
            if (i.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: Returns the number of items in allItems
    public int size() {
        return allItems.size();
    }
}
