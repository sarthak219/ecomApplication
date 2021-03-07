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
        assertEquals(item.getBrand(), testItem.getBrand());
        assertEquals(item.getDescription(), testItem.getDescription());
        assertEquals(item.getPrice(), testItem.getPrice());
        assertEquals(item.getCategory(), testItem.getCategory());
        assertEquals(item.getSize(), testItem.getSize());
        assertEquals(item.getColour(), testItem.getColour());
        assertEquals(item.getDiscount(), testItem.getDiscount());
        assertEquals(item.getInStock(), testItem.getInStock());
        item.showItem();
    }

    @Test
    public void newItemWithParametrizedConstructor() {
        Item testItem = new Item(1001, "test1", "brand1", "desc1", (float) 100.1, "men", "L");
        assertEquals(1001, testItem.getId());
        assertEquals("test1", testItem.getName());
        assertEquals("brand1", testItem.getBrand());
        assertEquals("desc1", testItem.getDescription());
        assertEquals((float)100.1, testItem.getPrice());
        assertEquals("men", testItem.getCategory());
        assertEquals("L", testItem.getSize());
    }
}
