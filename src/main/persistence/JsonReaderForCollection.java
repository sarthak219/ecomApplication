package persistence;

import model.Collection;
import model.Item;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;


/*
 * Citation: Code referenced from JsonSerializationDemo
 * link to GitHub repo: "https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git"
 */

// Represents a reader that reads Collection object data from JSON data stored in file
public class JsonReaderForCollection extends JsonReader {
    public JsonReaderForCollection(String source) {
        super(source);
    }

    // EFFECTS: reads allItems from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Collection read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCollection(jsonObject);
    }

    // EFFECTS: parses allItems from JSON object and returns it
    private Collection parseCollection(JSONObject jsonObject) {
        Collection items = new Collection();
        addItems(items, jsonObject);
        return items;
    }

    // MODIFIES: allItems
    // EFFECTS: parses items from JSON object and adds them to allItems
    private void addItems(Collection items, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(items, nextItem);
        }
    }

    // MODIFIES: allItems
    // EFFECTS: parses item from JSON object and adds it to items
    private void addItem(Collection items, JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        String name = jsonObject.getString("name");
        String brand = jsonObject.getString("brand");
        String description = jsonObject.getString("description");
        float price = jsonObject.getFloat("price");
        String category = jsonObject.getString("category");
        String size = jsonObject.getString("size");
        String colour = jsonObject.getString("colour");
        float discount = jsonObject.getFloat("discount");
        boolean inStock = jsonObject.getBoolean("inStock");
        Item item = new Item(id, name, brand, description, price, category, size);
        item.setDiscount(discount);
        item.setColour(colour);
        item.setInStock(inStock);
        items.insertItem(item);
    }
}
