package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTest {
    private Collection items;
    private static final double NUM_ITEMS = 500; //must be at least 3
    public int size;

    @BeforeEach
    public void runBefore() {
        items = new Collection();
        size = items.size();
    }

    @Test
    public void insertItemEmptyInEmptyTest() {
        Item item = new Item();
        items.insertItem(item);
        assertTrue(items.contains(item));
        assertEquals(1, items.size());
    }

    @Test
    public void insertItemManyInEmptyTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item testItem = new Item();
            testItem.setName(String.valueOf(i));
            testItem.setId(i + 1);
            testItem.setPrice(i * 100);
            items.insertItem(testItem);
        }

        for (Item item : items.getAllProducts()) {
            assertTrue(items.containsWithId(item.getId()));
        }

        assertEquals(NUM_ITEMS, items.size());
    }

    @Test
    public void insertItemManyInManyTest() {
        for (double i = 0; i < NUM_ITEMS; ++i) {
            Item testItem = new Item();
            testItem.setName(String.valueOf(i));
            testItem.setPrice((int) (i * 100));
            items.insertItem(testItem);
        }

        size = items.size();

        for (double i = NUM_ITEMS; i < 3 * NUM_ITEMS; ++i) {
            Item testItem = new Item();
            testItem.setName(String.valueOf(i));
            testItem.setPrice((int) (i * 100));
            items.insertItem(testItem);
        }

        assertEquals(3 * NUM_ITEMS, items.size());

        for (double i = 0; i < 3 * NUM_ITEMS; ++i) {
            Item testItem = new Item();
            testItem.setName(String.valueOf(i));
            testItem.setPrice((int) (i * 100));
            assertTrue(items.containsWithId(testItem.getId()));
        }
    }


    @Test
    public void removeItemFromListWithSingleItemTest() {
        Item testItem = new Item();
        testItem.setName("Test");
        testItem.setId(5);
        testItem.setPrice(5 * 100);
        size = items.size();
        items.removeItem(testItem.getId());
        assertEquals(0, items.size());
        assertFalse(items.containsWithId(testItem.getId()));
    }

    @Test
    public void removeItemFromListWithManyItemsTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item testItem = new Item();
            testItem.setName(String.valueOf(i));
            testItem.setId(i + 1);
            testItem.setPrice(i * 100);
            items.insertItem(testItem);
        }
        Item testItem;
        testItem = items.getAllProducts().get(2);
        size = items.size();

        items.removeItem(testItem.getId());
        assertEquals(NUM_ITEMS - 1, items.size());
        assertFalse(items.containsWithId(testItem.getId()));
    }

}