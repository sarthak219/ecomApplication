package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//represents the collection of all products in the store
public class Collection implements Writable {
    private final ArrayList<Item> allItems;

    //EFFECTS: constructs a new Collection of Items
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
    }

    //REQUIRES: allItems must have at least 1 item
    //MODIFIES: this
    //EFFECTS: removes the given Item from allItems
    public void removeItem(int id) {
        if (this.allItems.removeIf(item -> item.getId() == id)) {
            System.out.println("Item removed successfully!");
            return;
        }
        System.out.println("Item not found!");
    }

    // EFFECTS: Returns true if the given item is in allItems
    // and false otherwise
    public boolean contains(Item item) {
        return allItems.contains(item);
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


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("items", allItemsToJson());
        return json;
    }

    // EFFECTS: returns items in this Collection as a JSON array
    private JSONArray allItemsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Item item : allItems) {
            jsonArray.put(item.toJson());
        }
        return jsonArray;
    }
}
