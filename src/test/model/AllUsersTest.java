package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AllUsersTest {
    private AllUsers allUsers;
    private static final double NUM_USERS = 5; //must be at least 3
    public int size;

    @BeforeEach
    public void runBefore() {
        allUsers = new AllUsers();
        size = allUsers.size();
    }

    @Test
    public void insertUserEmptyInEmptyTest() {
        User user = new User();
        allUsers.insertUser(user);
        assertTrue(allUsers.getAllUsers().contains(user));
        assertEquals(1, allUsers.size());
    }

    @Test
    public void insertUserManyInEmptyTest() {
        for (int i = 0; i < NUM_USERS; ++i) {
            User testUser = new User();
            testUser.setUsername(String.valueOf(i + 1));
            allUsers.insertUser(testUser);
        }

        for (User user : allUsers.getAllUsers()) {
            assertTrue(allUsers.containsWithUsername(user.getUsername()));
        }

        assertEquals(NUM_USERS, allUsers.size());
    }

    @Test
    public void insertUserManyInManyTest() {
        for (int i = 0; i < NUM_USERS; ++i) {
            User testUser = new User();
            testUser.setUsername(String.valueOf(i + 1));
            allUsers.insertUser(testUser);
        }

        size = allUsers.size();

        for (int i = (int) NUM_USERS; i < 3 * NUM_USERS; ++i) {
            User testUser = new User();
            testUser.setUsername(String.valueOf(i + 1));
            allUsers.insertUser(testUser);
        }

        assertEquals(3 * NUM_USERS, allUsers.size());

        for (int i = 0; i < 3 * NUM_USERS; ++i) {
            User testItem = new User();
            testItem.setUsername(String.valueOf(i + 1));
            assertTrue(allUsers.containsWithUsername(testItem.getUsername()));
        }
    }

    @Test
    public void removeUserFromListOf1User() {
        User user = new User();
        user.setUsername("test");
        allUsers.insertUser(user);
        allUsers.removeUser(user.getUsername() + 1);
        assertEquals(1, allUsers.size());

        assertTrue(allUsers.containsWithUsername(user.getUsername()));
        allUsers.removeUser(user.getUsername());
        assertEquals(0, allUsers.size());
        assertFalse(allUsers.containsWithUsername(user.getUsername()));
    }

    @Test
    public void removeUserFromListOfManyUser() {
        for (int i = 0; i < NUM_USERS; ++i) {
            User user = new User();
            user.setUsername("test" + i);
            allUsers.insertUser(user);
        }
        assertEquals(NUM_USERS, allUsers.size());

        for (int i = 0; i < NUM_USERS; ++i) {
            User user = new User();
            user.setUsername("test" + i);
            assertTrue(allUsers.containsWithUsername(user.getUsername()));
            allUsers.removeUser(user.getUsername());
            assertEquals(NUM_USERS - (i + 1), allUsers.size());
            assertFalse(allUsers.containsWithUsername(user.getUsername()));
        }

    }


    @Test
    public void userAuthenticationWithOneUserTest() {
        User user = new User();
        user.setUsername("test1");
        user.setPassword("123");
        allUsers.insertUser(user);
        assertFalse(allUsers.userAuthentication("test", "1234"));
        assertTrue(allUsers.userAuthentication("test1", "123"));
    }

    @Test
    public void userAuthenticationWithManyUsersTest() {
        for (int i = 0; i < NUM_USERS; ++i) {
            User user = new User();
            user.setUsername("test" + i);
            user.setPassword("pass_" + i);
            allUsers.insertUser(user);
        }

        for (int i = 0; i < NUM_USERS; ++i) {
            User user = new User();
            user.setUsername("test" + i);
            user.setPassword("pass_" + i);
            assertTrue(allUsers.userAuthentication(user.getUsername(), user.getPassword()));
        }
    }
}
