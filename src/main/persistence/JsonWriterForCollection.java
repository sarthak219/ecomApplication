package persistence;

import model.Collection;
import org.json.JSONObject;

/*
 * Citation: Code referenced from JsonSerializationDemo
 * link to GitHub repo: "https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git"
 */

// Represents a writer that writes JSON representation of Collection to file
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
