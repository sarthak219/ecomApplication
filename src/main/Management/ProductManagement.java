package Management;

import model.Collection;

import java.util.Scanner;

public class ProductManagement {
    Scanner sc = new Scanner(System.in);
    Collection items = new Collection();

    //EFFECTS: adds new item to the collection
    public void addNewItems() {
        int cont = 1;
        while (cont == 1) {
            if (cont != 1) {
                break;
            }
            items.insertItem(items.getItem());
            //items.displayAllItems();
            System.out.println("Item added successfully!");
            System.out.println("Wish to add more items?(Enter 1 for yes, 0 for no)");
            cont = sc.nextInt();
        }
        //items.displayAllItems();
    }

    //EFFECTS: Displays all the items in database
    public void displayItems() {
        items.displayAllItems();
    }
}
