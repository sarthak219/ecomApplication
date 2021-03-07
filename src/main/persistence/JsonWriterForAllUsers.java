package persistence;

import model.AllUsers;
import org.json.JSONObject;

/*
 * Citation: Code referenced from JsonSerializationDemo
 * link to GitHub repo: "https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git"
 */

// Represents a writer that writes JSON representation of AllUsers to file
public class JsonWriterForAllUsers extends JsonWriter {
    public JsonWriterForAllUsers(String destination) {
        super(destination);
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of AllUsers to file
    public void write(AllUsers allUser) {
        JSONObject json = allUser.toJson();
        saveToFile(json.toString(TAB));
    }
}
