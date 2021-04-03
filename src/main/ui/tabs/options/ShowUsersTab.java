package ui.tabs.options;

import ui.Database;
import model.AllUsers;
import model.User;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Locale;

/**
 * represents an OptionTab to display a Table of Users
 */
public class ShowUsersTab extends OptionTab {
    protected AllUsers users;
    protected Object[][] rows = null;
    protected Border border = BorderFactory.createLineBorder(Color.BLACK);
    String[] columnNames = {"SNo.", "First Name", "Last Name", "Username", "Email", "Password", "Mobile Number", "Age",
            "Gender"};
    protected JTable table;
    protected DefaultTableModel tableModel;
    protected JScrollPane scrollPane;

    //EFFECTS: constructs a Show Users tab
    public ShowUsersTab(String title, Dimension dimension, Database database) {
        super(title, dimension, database);
        this.users = database.getUsers();
        this.tableModel = new DefaultTableModel(rows, columnNames);
        update("");
        validate();
        repaint();
    }

    //EFFECTS: initialises the JTable
    public void initializeTable(String searchString) {
        this.table = new JTable(tableModel) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        table.setBorder(border);
        table.setFont(new Font("helvetica", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("helvetica", Font.PLAIN, 13));
        table.getTableHeader().setPreferredSize(new Dimension(getWidth(), 30));
        table.setCellSelectionEnabled(false);
        addRows(searchString);
        initialiseScrollPane();
    }

    //EFFECTS: adds table to scrollPane
    public void initialiseScrollPane() {
        this.scrollPane = new JScrollPane(table, 20, 30);
        scrollPane.setOpaque(false);
        scrollPane.setBackground(new Color(23, 23, 23));
        add(scrollPane);
    }

    //EFFECTS: adds rows to the table, with each row having User credentials
    public void addRows(String subString) {
        int i = 1;
        for (User user : users.getAllUsers()) {
            if (isInFirstName(user, subString) | isInUserName(user, subString) | isInLastName(user, subString)) {
                String sno = Integer.toString(i);
                String firstName = user.getFirstName();
                String lastName = user.getLastName();
                String username = user.getUsername();
                String email = user.getEmailId();
                String password = user.getPassword();
                String mobileNum = user.getMobileNumber();
                String age = Integer.toString(user.getAge());
                String gender = user.getGender();
                String[] row = {sno, firstName, lastName, username, email, password, mobileNum, age, gender};
                tableModel.addRow(row);
                ++i;
            }
        }
    }

    //EFFECTS: returns true if the user's first name contains the given string (ignoring case)
    //         false otherwise
    private boolean isInFirstName(User user, String searchString) {
        return user.getFirstName().toLowerCase(Locale.ROOT).contains(searchString.toLowerCase(Locale.ROOT));
    }

    //EFFECTS: returns true if the user's last name contains the given string (ignoring case)
    //         false otherwise
    private boolean isInLastName(User user, String searchString) {
        return user.getLastName().toLowerCase(Locale.ROOT).contains(searchString.toLowerCase(Locale.ROOT));
    }

    //EFFECTS: returns true if the user's username contains the given string (ignoring case)
    //         false otherwise
    private boolean isInUserName(User user, String searchString) {
        return user.getUsername().toLowerCase(Locale.ROOT).contains(searchString.toLowerCase(Locale.ROOT));
    }

    @Override
    public void update(String searchString) {
        removeAll();
        addTitle(title);
        this.tableModel.getDataVector().removeAllElements();
        initializeTable(searchString);
        validate();
        repaint();
    }
}
