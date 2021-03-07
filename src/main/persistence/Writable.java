package persistence;

import org.json.JSONObject;

/*
 * Citation: Code obtained from JsonSerializationDemo
 * link to GitHub repo: "https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git"
 */

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
