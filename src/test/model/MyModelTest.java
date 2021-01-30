package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTest {
    private Collection items;
    private static final double NUMITEMS = 10;
    private int size;

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
        for (int i = 0; i < NUMITEMS; ++i) {
            Item testItem = new Item();
            testItem.setName(String.valueOf(i));
            testItem.setPrice(i * 100);
            items.insertItem(testItem);
        }

        for (int i = 0; i < NUMITEMS; ++i) {
            Item testItem = new Item();
            testItem.setName(String.valueOf(i));
            testItem.setPrice(i * 100);
            assertTrue(items.containsWithName(testItem.getName()));
        }

        assertEquals(NUMITEMS, items.size());
    }

    @Test
    public void insertItemManyInManyTest() {
        for (double i = 0; i < NUMITEMS; ++i) {
            Item testItem = new Item();
            testItem.setName(String.valueOf(i));
            testItem.setPrice((int) (i * 100));
            items.insertItem(testItem);
        }

        size = items.size();

        for (double i = NUMITEMS; i < 3 * NUMITEMS; ++i) {
            Item testItem = new Item();
            testItem.setName(String.valueOf(i));
            testItem.setPrice((int) (i * 100));
            items.insertItem(testItem);
        }

        assertEquals(3 * NUMITEMS, items.size());

        for (double i = 0; i < 3 * NUMITEMS; ++i) {
            Item testItem = new Item();
            testItem.setName(String.valueOf(i));
            testItem.setPrice((int) (i * 100));
            assertTrue(items.containsWithName(testItem.getName()));
        }

    }
}