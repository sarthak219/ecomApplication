package ui;

import model.Collection;
import model.Item;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Collection items = new Collection();
        Scanner sc = new Scanner(System.in);
        int cont = 1;

        Item xx = new Item();
        xx.setName("tshirt");
        xx.setDescription("Great_tshirt");
        xx.setPrice(200);
        xx.setCategory("male");
        xx.setType("tshirt");
        xx.setSize("M");
        xx.setColour("Black");
        xx.setDiscount(10);
        xx.setInStock(true);

        while (cont == 1) {
            if (cont != 1) {
                break;
            }
            items.insertItem(items.getItem());
            items.displayAllItems();

            System.out.println("Wish to add more items?(1/0)");
            cont = sc.nextInt();
        }
    }
}
