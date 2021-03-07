package persistence;

import model.Collection;
import model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterForCollectionTest extends JsonCollectionTest {
    Collection items;

    @BeforeEach
    public void setup() {
        items = new Collection();
    }

    @Test
    public void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyCollection() {
        try {
            JsonWriterForCollection writer = new JsonWriterForCollection("./data/testWriterEmptyCollection.json");
            writer.open();
            writer.write(items);
            writer.close();

            JsonReaderForCollection reader = new JsonReaderForCollection("./data/testWriterEmptyCollection.json");
            items = reader.read();
            assertEquals(0, items.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralCollection() {
        try {
            Item item1 = new Item(1001, "tshirt", "nike", "soft", 100, "men", "S");
            item1.setColour("red");
            item1.setDiscount(10);
            item1.setInStock(true);

            Item item2 = new Item(1002, "tshirt1", "puma", "rough", 200, "women", "M");
            item2.setColour("pink");
            item2.setDiscount(15);
            item2.setInStock(true);

            items.insertItem(item1);
            items.insertItem(item2);
            JsonWriterForCollection writer = new JsonWriterForCollection("./data/testWriterGeneralCollection.json");
            writer.open();
            writer.write(items);
            writer.close();

            JsonReaderForCollection reader = new JsonReaderForCollection("./data/testWriterGeneralCollection.json");
            items = reader.read();
            assertEquals(2, items.size());
            checkItem(1001, "tshirt", "nike", "soft", 100, "men", "S",
                    "red", 10, true, items.getAllProducts().get(0));
            checkItem(1002, "tshirt1", "puma", "rough", 200, "women", "M",
                    "pink", 15, true, items.getAllProducts().get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
