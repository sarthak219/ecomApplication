package persistence;

import model.Collection;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderForCollectionTest extends JsonCollectionTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReaderForCollection reader = new JsonReaderForCollection("./data/noSuchFile.json");
        try {
            Collection items = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCollection() {
        JsonReaderForCollection reader = new JsonReaderForCollection("./data/testReaderEmptyCollection.json");
        try {
            Collection items = reader.read();
            assertEquals(0, items.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCollection() {
        JsonReaderForCollection reader = new JsonReaderForCollection("./data/testReaderGeneralCollection.json");
        try {
            Collection items = reader.read();
            assertEquals(2, items.size());
            checkItem(1001, "tshirt", "nike", "soft", 100, "men", "S",
                    "red", 10, true, items.getAllProducts().get(0));
            checkItem(1002, "tshirt1", "puma", "rough", 200, "women", "M",
                    "pink", 15, true, items.getAllProducts().get(1));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
