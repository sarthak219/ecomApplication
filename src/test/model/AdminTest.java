package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    private Admin admin;

    @BeforeEach
    public void setup() {
        admin = new Admin();
    }

    @Test
    public void adminAuthenticationWithDefaultCredentialsTest() {
        assertFalse(admin.adminAuthentication(admin.getUsername() + 1, admin.getPassword() + 1));
        assertFalse(admin.adminAuthentication(admin.getUsername(), admin.getPassword() + 1));
        assertFalse(admin.adminAuthentication(admin.getUsername() + 1, admin.getPassword()));
        assertTrue(admin.adminAuthentication(admin.getUsername(), admin.getPassword()));
    }

    @Test
    public void adminAuthenticationWithNewCredentialsTest() {
        String oldUsername = admin.getUsername();
        String oldPassword = admin.getPassword();
        admin.setUsername(admin.getUsername() + 1);
        admin.setPassword(admin.getPassword() + 1);
        assertFalse(admin.adminAuthentication(oldUsername, oldPassword));
        assertFalse(admin.adminAuthentication(oldUsername, oldPassword + 1));
        assertFalse(admin.adminAuthentication(oldUsername + 1, oldPassword));
        assertTrue(admin.adminAuthentication(oldUsername + 1, oldPassword + 1));
    }
}
