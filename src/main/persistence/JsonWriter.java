package persistence;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
 * Citation: Code obtained from JsonSerializationDemo
 * link to GitHub repo: "https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git"
 */

//represents a JSON Writer which writes JSON representation of object to the file
public class JsonWriter {
    protected static final int TAB = 4;
    protected PrintWriter writer;
    protected String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    protected void saveToFile(String json) {
        writer.print(json);
    }
}
