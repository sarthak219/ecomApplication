package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Collection {
    private List<Item> allItems;

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

    //Effects: Takes values for all the fields of an Item and returns
    //         and Item with those credentials
    public Item getItem() {
        Item item = new Item();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the product:");
        item.setName(sc.next());
        System.out.println("Enter a small description of the product");
        item.setDescription(sc.next());
        System.out.println("Enter price of the product");
        item.setPrice(sc.nextInt());
        System.out.println("Enter gender category of the product(male/female/kids)");
        item.setCategory(sc.next());
        System.out.println("Enter type of product(tshirt/jeans/suit/shirt/pant/dress/gown/frock)");
        item.setType(sc.next());
        System.out.println("Enter size of the product");
        item.setSize(sc.next());
        System.out.println("Enter colour of the product");
        item.setColour(sc.next());
        System.out.println("Enter discount % of the product");
        item.setDiscount(sc.nextInt());
        System.out.println("Enter inStock Status (True/false)");
        item.setInStock(sc.nextBoolean());
        return item;
    }


    //EFFECTS: Displays all the products
    public void displayAllItems() {
        System.out.print("\nSNo.\tName\tDescription\tPrice\tCategory\tType\tSize\tColour\tDiscount\tinStock\n");
        for (int i = 0; i < allItems.size(); i++) {
            System.out.print(i + 1 + "\t\t");
            allItems.get(i).showItem();
        }
    }
}
