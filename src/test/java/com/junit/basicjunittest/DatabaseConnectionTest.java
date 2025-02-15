package com.junit.basicjunittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DatabaseConnectionTest {

    DatabaseConnection db;

    @BeforeEach
    public void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    public void tearDown() {
        db.disconnect();
    }

    @Test
    public void testConnectionIsEstablished() {
        // Check that connection is established
        assertTrue(db.isConnected());
    }

    @Test
    public void testDisconnectClosesConnection() {
        // Manually disconnect and check that connection is closed
        db.disconnect();
        assertFalse(db.isConnected());
    }
}