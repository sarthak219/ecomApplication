package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    Item item;
    @BeforeEach
    public void setup() {
        item = new Item();
        item.setId(1001);
        item.setName("testItem");
        item.setBrand("Brand Name");
        item.setDescription("description of item");
        item.setPrice(100);
        item.setCategory("men");
        item.setSize("M");
        item.setColour("black");
        item.setDiscount(0);
        item.setInStock(true);
    }

    @Test
    public void newItemTest() {
        Item testItem = item;
        assertEquals(item.getId(), testItem.getId());
        assertEquals(item.getName(), testItem.getName());
        assertEquals(item.getPrice(), testItem.getPrice());
        assertEquals(item.getDiscount(), testItem.getDiscount());
        assertEquals(item.getInStock(), testItem.getInStock());
        item.showItem();
    }
}
