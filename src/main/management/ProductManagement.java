package management;

import model.Collection;

import java.util.Scanner;

public class ProductManagement {
    Scanner sc = new Scanner(System.in);
    Collection items = new Collection();

    //EFFECTS: adds new item to the collection
    public void addNewItems() {
        int cont;
        while (true) {
            items.insertItem(items.getItem());
            //items.displayAllItems();
            System.out.println("Item added successfully!");
            System.out.println("Wish to add more items?(Enter 1 for yes, 0 for no)");
            cont = sc.nextInt();
            if (cont != 1) {
                break;
            }
        }
        //items.displayAllItems();
    }

    //EFFECTS: Displays all the items in database
    public void displayItems() {
        items.displayAllItems();
    }
}
