package persistence;

import model.AllUsers;
import model.Item;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderForAllUsersTest extends JsonAllUsersTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReaderForAllUsers reader = new JsonReaderForAllUsers("./data/noSuchFile.json");
        try {
            AllUsers allUsers = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReaderForAllUsers reader = new JsonReaderForAllUsers("./data/testReaderEmptyAllUsers.json");
        try {
            AllUsers allUsers = reader.read();
            assertEquals(0, allUsers.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
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

        try {
            JsonReaderForAllUsers reader = new JsonReaderForAllUsers("./data/testReaderGeneralAllUsers.json");
            AllUsers allUsers = reader.read();
            checkUser("fName2", "lName2", "username2", "email2", "pass2",
                    "123",11, "female", tempList1, tempList2, tempList2, allUsers.getAllUsers().get(1));

            checkUser("fName1", "lName1", "username1", "email1", "pass1",
                    "345",12, "male", tempList2, tempList1, tempList1, allUsers.getAllUsers().get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
