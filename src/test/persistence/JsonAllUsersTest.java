package persistence;

import model.Item;
import model.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonAllUsersTest {
    protected void checkUser(String firstname, String lastname, String username, String emailId, String password,
                             String mobileNumber, int age, String gender, ArrayList<Item> wishlist,
                             ArrayList<Item> cart, ArrayList<Item> orderHistory,User user) {
        assertEquals(firstname, user.getFirstName());
        assertEquals(lastname, user.getLastName());
        assertEquals(username, user.getUsername());
        assertEquals(emailId, user.getEmailId());
        assertEquals(password, user.getPassword());
        assertEquals(mobileNumber,user.getMobileNumber());
        assertEquals(age, user.getAge());
        assertEquals(gender, user.getGender());
        assertEquals(wishlist.size(), user.getWishlist().size());
        assertEquals(cart.size(), user.getCart().size());
        assertEquals(orderHistory.size(), user.getOrderHistory().size());
    }
}
