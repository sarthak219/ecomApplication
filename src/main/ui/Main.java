package ui;

import model.Collection;
import model.Item;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Collection items = new Collection();
        Scanner sc = new Scanner(System.in);
        int cont = 1;

//        Item xx1 = new Item();
//        xx1.setName("tshirt");
//        xx1.setDescription("Great tshirt with many colours");
//        xx1.setPrice(200);
//        xx1.setCategory("male");
//        xx1.setType("tshirt");
//        xx1.setSize("M");
//        xx1.setColour("Black");
//        xx1.setDiscount(10);
//        xx1.setInStock(true);

        while (cont == 1) {
            if (cont != 1) {
                break;
            }
            items.insertItem(items.getItem());
            //items.displayAllItems();
            System.out.println("Item added successfully!");
            System.out.println("Wish to add more items?(1/0)");
            cont = sc.nextInt();
        }
        items.displayAllItems();

    }
}
