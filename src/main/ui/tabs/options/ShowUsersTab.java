package ui.tabs.options;

import database.Database;
import model.AllUsers;
import model.User;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowUsersTab extends OptionTab {
    protected AllUsers users;
    protected Object[][] rows = null;
    protected Border border = BorderFactory.createLineBorder(Color.BLACK);
    String[] columnNames = {"SNo.", "First Name", "Last Name", "Username", "Email", "Password", "Mobile Number", "Age",
            "Gender"};
    protected JTable table;
    protected DefaultTableModel tableModel;
    protected JScrollPane scrollPane;

    public ShowUsersTab(Dimension dimension, Database database) {
        super(dimension, database);
        this.users = database.getUsers();
        this.tableModel = new DefaultTableModel(rows, columnNames);
        updatePanel();
        validate();
        repaint();
    }

    //EFFECTS: initialises the JTable
    public void initializeTable() {
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
        addRows();
        initialiseScrollPane();
    }

    //EFFECTS: adds table to scrollPane
    public void initialiseScrollPane() {
        this.scrollPane = new JScrollPane(table, 20, 30);
        scrollPane.setOpaque(false);
        scrollPane.setBackground(new Color(23, 23, 23));
        add(scrollPane);
    }

    //EFFECTS: adds rows to the table with User credentials
    public void addRows() {
        int i = 1;
        for (User user : users.getAllUsers()) {
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

    //EFFECTS: refreshes the table
    public void updatePanel() {
        removeAll();
        this.tableModel.getDataVector().removeAllElements();
        initializeTable();
        validate();
        repaint();
    }
}
