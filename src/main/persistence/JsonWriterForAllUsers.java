package persistence;

import model.AllUsers;
import org.json.JSONObject;

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
