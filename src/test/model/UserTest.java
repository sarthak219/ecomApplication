package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private static final double NUM_ITEMS = 5; //must be at least 3

    @BeforeEach
    public void setup() {
        user = new User();
        user.makeGuestUser();
        user.setFirstName("fName");
        user.setLastName("lName");
        user.setUsername("NewUser");
        user.setEmailId("abc@xyz.com");
        user.setPassword("pass1");
        user.setMobileNumber("9876543210");
        user.setAge(18);
        user.setGender("male");
        user.setWishlist(new ArrayList<>());
        user.setCart(new ArrayList<>());
        user.setOrderHistory(new ArrayList<>());
    }

    @Test
    public void matchNewUserCredentialsTest() {
        assertEquals("fName", user.getFirstName());
        assertEquals("lName", user.getLastName());
        assertEquals("NewUser", user.getUsername());
        assertEquals("abc@xyz.com", user.getEmailId());
        assertEquals("pass1", user.getPassword());
        assertEquals("9876543210", user.getMobileNumber());
        assertEquals(18, user.getAge());
        assertEquals("male", user.getGender());
        assertEquals(0, user.getWishlist().size());
        assertEquals(0, user.getCart().size());
        assertEquals(0, user.getOrderHistory().size());
        user.showUser();
    }

    @Test
    public void matchNewUserCredentialsWithParametrizedConstructorTest() {
        User testUser = new User("fName1", "lName1", "username", "email", "pass", 11);
        assertEquals("fName1", testUser.getFirstName());
        assertEquals("lName1", testUser.getLastName());
        assertEquals("username", testUser.getUsername());
        assertEquals("email", testUser.getEmailId());
        assertEquals("pass", testUser.getPassword());
        assertEquals(11, testUser.getAge());
    }

    @Test
    public void addOneItemToEmptyWishlistTest() {
        Item item = new Item();
        item.setId(100);
        item.setName("test");
        user.addItemToWishlist(item);
        assertEquals(1, user.getWishlist().size());
        assertTrue(user.wishListContainsItemWithId(item.getId()));
        assertTrue(user.inWishlist(item));
        assertFalse(user.wishListContainsItemWithId(item.getId() + 1));
    }

    @Test
    public void addManyItemToEmptyWishlistTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.addItemToWishlist(item);
        }
        assertEquals(NUM_ITEMS, user.getWishlist().size());

        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            assertTrue(user.wishListContainsItemWithId(item.getId()));
            assertFalse(user.wishListContainsItemWithId(item.getId() + (int) NUM_ITEMS));
        }
    }

    @Test
    public void addManyItemToFilledWishlistTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.addItemToWishlist(item);
        }
        assertEquals(NUM_ITEMS, user.getWishlist().size());

        for (int i = (int) NUM_ITEMS; i < 3 * NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.addItemToWishlist(item);
        }
        assertEquals(3 * NUM_ITEMS, user.getWishlist().size());

        for (int i = (int) NUM_ITEMS; i < 3 * NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            assertTrue(user.wishListContainsItemWithId(item.getId()));
            assertFalse(user.wishListContainsItemWithId(item.getId() + 2 * (int) NUM_ITEMS));
        }
    }

    @Test
    public void addOneItemToEmptyCartTest() {
        Item item = new Item();
        item.setId(100);
        item.setName("test");
        user.addItemToCart(item);
        assertTrue(user.inCart(item));
        assertEquals(1, user.getCart().size());
        assertTrue(user.cartContainsItemWithId(item.getId()));
        assertFalse(user.cartContainsItemWithId(item.getId() + 1));
    }

    @Test
    public void addManyItemToEmptyCartTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.addItemToCart(item);
        }
        assertEquals(NUM_ITEMS, user.getCart().size());

        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            assertTrue(user.cartContainsItemWithId(item.getId()));
            assertFalse(user.cartContainsItemWithId(item.getId() + (int) NUM_ITEMS));
        }
    }

    @Test
    public void addManyItemToFilledCartTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.addItemToCart(item);
        }
        assertEquals(NUM_ITEMS, user.getCart().size());

        for (int i = (int) NUM_ITEMS; i < 3 * NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.addItemToCart(item);
        }
        assertEquals(3 * NUM_ITEMS, user.getCart().size());

        for (int i = (int) NUM_ITEMS; i < 3 * NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            assertTrue(user.cartContainsItemWithId(item.getId()));
            assertFalse(user.cartContainsItemWithId(item.getId() + 2 * (int) NUM_ITEMS));
        }
    }

    @Test
    public void addOneItemToEmptyOrderHistoryTest() {
        Item item = new Item();
        item.setId(100);
        item.setName("test");
        user.addItemToOrderHistory(item);
        assertEquals(1, user.getOrderHistory().size());
        assertTrue(user.orderHistoryContainsItemWithId(item.getId()));
        assertFalse(user.orderHistoryContainsItemWithId(item.getId() + 1));
    }

    @Test
    public void addManyItemToEmptyOrderHistoryTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.addItemToOrderHistory(item);
        }
        assertEquals(NUM_ITEMS, user.getOrderHistory().size());

        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            assertTrue(user.orderHistoryContainsItemWithId(item.getId()));
            assertFalse(user.orderHistoryContainsItemWithId(item.getId() + (int) NUM_ITEMS));
        }
    }

    @Test
    public void addManyItemToFilledOrderHistoryTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.addItemToOrderHistory(item);
        }
        assertEquals(NUM_ITEMS, user.getOrderHistory().size());

        for (int i = (int) NUM_ITEMS; i < 3 * NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            user.addItemToOrderHistory(item);
        }
        assertEquals(3 * NUM_ITEMS, user.getOrderHistory().size());

        for (int i = (int) NUM_ITEMS; i < 3 * NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i + 1);
            item.setName("test" + (i + 1));
            assertTrue(user.orderHistoryContainsItemWithId(item.getId()));
            assertFalse(user.orderHistoryContainsItemWithId(item.getId() + 2 * (int) NUM_ITEMS));
        }
    }

    @Test
    public void removeItemFromWishlistWith1ItemTest() {
        Item item = new Item();
        item.setId(1001);
        item.setName("testItem");
        user.addItemToWishlist(item);

        user.removeItemsFromWishlist(item);
        assertEquals(0, user.getWishlist().size());
    }

    @Test
    public void removeItemFromWishlistWithManyItemsTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i);
            item.setName("test" + i);
            user.addItemToWishlist(item);
        }
        assertEquals(NUM_ITEMS, user.getWishlist().size());

        assertTrue(user.wishListContainsItemWithId(1));
        user.removeItemsFromWishlist(user.getWishlist().get(1));
        assertEquals(NUM_ITEMS - 1, user.getWishlist().size());
        assertFalse(user.wishListContainsItemWithId(1));
    }

    @Test
    public void removeItemFromCartWith1ItemTest() {
        Item item = new Item();
        item.setId(1001);
        item.setName("testItem");
        user.addItemToCart(item);

        user.removeItemsFromCart(item);
        assertEquals(0, user.getCart().size());
    }

    @Test
    public void removeItemFromCartWithManyItemsTest() {
        for (int i = 0; i < NUM_ITEMS; ++i) {
            Item item = new Item();
            item.setId(i);
            item.setName("test" + i);
            user.addItemToCart(item);
        }
        assertEquals(NUM_ITEMS, user.getCart().size());

        assertTrue(user.cartContainsItemWithId(1));
        user.removeItemsFromCart(user.getCart().get(1));
        assertEquals(NUM_ITEMS - 1, user.getCart().size());
        assertFalse(user.cartContainsItemWithId(1));
    }

    @Test
    public void TotalBillTest() {
        assertEquals(0, user.totalBill());

        Item item1 = new Item();
        item1.setPrice(200);
        item1.setDiscount(10);
        user.addItemToCart(item1);
        assertEquals(180, user.totalBill());

        Item item2 = new Item();
        item2.setPrice(200);
        item2.setDiscount(5);
        user.addItemToCart(item2);
        assertEquals(190 + 180, user.totalBill());

        Item item3 = new Item();
        item3.setPrice(1000);
        item3.setDiscount(100);
        user.addItemToCart(item3);
        assertEquals(190 + 180, user.totalBill());
    }

    @Test
    public void orderItemTest() {
        Item item1 = new Item();
        item1.setId(1001);
        item1.setPrice(200);
        item1.setDiscount(10);
        user.addItemToCart(item1);
        user.addItemToWishlist(item1);
        user.orderItem(item1);
        assertFalse(user.inCart(item1));
        assertFalse(user.cartContainsItemWithId(item1.getId()));
        assertFalse(user.wishListContainsItemWithId(item1.getId()));
        assertFalse(user.inWishlist(item1));
        assertTrue(user.orderHistoryContainsItemWithId(item1.getId()));
        assertFalse(item1.getInStock());
        for (Item product : user.getOrderHistory()) {
            if (item1.getId() == product.getId()) {
                assertFalse(product.getInStock());
            }
        }
    }
}
