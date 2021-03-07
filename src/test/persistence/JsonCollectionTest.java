package persistence;

import model.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonCollectionTest {
    protected void checkItem(int id, String name, String brand, String description, float price, String category,
                                String size, String colour, float discount, boolean inStock, Item item) {
        assertEquals(name, item.getName());
        assertEquals(brand, item.getBrand());
        assertEquals(description, item.getDescription());
        assertEquals(price, item.getPrice());
        assertEquals(category, item.getCategory());
        assertEquals(size,item.getSize());
        assertEquals(colour, item.getColour());
        assertEquals(discount, item.getDiscount());
        assertEquals(inStock, item.isInStock());
    }
}
