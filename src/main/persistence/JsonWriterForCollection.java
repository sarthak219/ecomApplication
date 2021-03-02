package persistence;

import model.AllUsers;
import model.Collection;
import org.json.JSONObject;

public class JsonWriterForCollection extends JsonWriter {
    public JsonWriterForCollection(String destination) {
        super(destination);
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of AllUsers to file
    public void write(Collection allProducts) {
        JSONObject json = allProducts.toJson();
        saveToFile(json.toString(TAB));
    }
}
