package persistence;

import model.AllUsers;
import model.Item;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterForAllUsersTest extends JsonAllUsersTest {
    AllUsers allUsers;

    @BeforeEach
    public void setup() {
        allUsers = new AllUsers();
    }

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyAllUsers() {
        try {
            JsonWriterForAllUsers writer = new JsonWriterForAllUsers("./data/testWriterEmptyAllUsers.json");
            writer.open();
            writer.write(allUsers);
            writer.close();

            JsonReaderForAllUsers reader = new JsonReaderForAllUsers("./data/testWriterEmptyAllUsers.json");
            allUsers = reader.read();
            assertEquals(0, allUsers.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralAllUsers() {
        try {
            ArrayList<Item> tempList1 = new ArrayList<>();
            ArrayList<Item> tempList2 = new ArrayList<>();

            Item item1 = new Item(1001, "tshirt", "nike", "soft", 100, "men", "S");
            item1.setColour("red");
            item1.setDiscount(10);
            item1.setInStock(true);

            Item item2 = new Item(1002, "tshirt1", "puma", "rough", 200, "women", "M");
            item2.setColour("pink");
            item2.setDiscount(15);
            item2.setInStock(true);

            tempList1.add(item1);
            tempList1.add(item2);

            User user1 = new User("fName1", "lName1", "username1", "email1", "pass1", 12);
            user1.setMobileNumber("345");
            user1.setGender("male");
            user1.setWishlist(tempList2);
            user1.setCart(tempList1);
            user1.setOrderHistory(tempList1);

            User user2 = new User("fName2", "lName2", "username2", "email2", "pass2", 11);
            user2.setMobileNumber("123");
            user2.setGender("female");
            user2.setWishlist(tempList1);
            user2.setCart(tempList2);
            user2.setOrderHistory(tempList2);

            allUsers.insertUser(user1);
            allUsers.insertUser(user2);

            JsonWriterForAllUsers writer = new JsonWriterForAllUsers("./data/testWriterGeneralAllUsers.json");
            writer.open();
            writer.write(allUsers);
            writer.close();

            JsonReaderForAllUsers reader = new JsonReaderForAllUsers("./data/testWriterGeneralAllUsers.json");
            allUsers = reader.read();
            checkUser("fName2", "lName2", "username2", "email2", "pass2",
                    "123",11, "female", tempList1, tempList2, tempList2, user2);

            checkUser("fName1", "lName1", "username1", "email1", "pass1",
                    "345",12, "male", tempList2, tempList1, tempList1, user1);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
