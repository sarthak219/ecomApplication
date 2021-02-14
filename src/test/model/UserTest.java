package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private static final double NUM_ITEMS = 5;

    @BeforeEach
    public void setup() {
        user = new User();
        user.makeGuestUser();
    }

    @Test
    public void addOneItemToEmptyWishlistTest() {
        Item item = new Item();
        item.setId(100);
        item.setName("test");
        user.getWishlist().add(item);
        assertEquals(1, user.getWishlist().size());
        assertTrue(user.inWishlist(item));
    }

    @Test
    public void addManyItemToEmptyWishlistTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.getWishlist().add(item);
        }
        assertEquals(NUM_ITEMS, user.getWishlist().size());

        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            assertTrue(user.wishListContainsItemWithId(item.getId()));
        }
    }

    @Test
    public void addManyItemToFilledWishlistTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.getWishlist().add(item);
        }
        assertEquals(NUM_ITEMS, user.getWishlist().size());

        for (int i = (int) NUM_ITEMS; i < 3 * NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.getWishlist().add(item);
        }
        assertEquals(3 * NUM_ITEMS, user.getWishlist().size());

        for (int i = (int) NUM_ITEMS; i < 3 * NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            assertTrue(user.wishListContainsItemWithId(item.getId()));
        }
    }
}
