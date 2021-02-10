package model;

import java.util.ArrayList;

public class AllUsers {
    //Scanner sc = new Scanner(System.in);

    private final ArrayList<User>  allUsers;

    public AllUsers() {
        this.allUsers = new ArrayList<>();
    }

    //EFFECTS: returns allUsers
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    //REQUIRES: User with same username should not already be present in allUsers
    //MODIFIES: this
    //EFFECTS: Item will be added to allUsers
    public void insertUser(User user) {
        if (!allUsers.contains(user)) {
            this.allUsers.add(user);
        } else {
            System.out.println("ERROR! Item already exists in the list");
        }
    }
//
//    //EFFECTS: adds a horizontal line of to separate rows of a table
//    private void addLine() {
//        System.out.print("+-------+---------------------+---------------------+--------------------------------------"
//                + "-------------+--------+----------+----------------+-------+-----------+-----------+----------+\n");
//    }
//
//    public void displayAllUsers() {
//        addLine();
//        System.out.printf("| %-6s| %-20s|  %-20s| %-20s| %-50s| %-20s| %-15s| %-5s| %-10s|\n",
//                "SNo.", "First Name", "Last Name", "Username", "Email", "Password", "Mobile Number", "Age",
//                "Gender");
//
//        addLine();
//        for (int i = 0; i < allUsers.size(); i++) {
//            System.out.printf("| %-6d", i + 1);
//            allUsers.get(i).showUser();
//        }
//        addLine();
//    }



    //TODO: Implement displayUser()
    //TODO: Write tests
}
