package com.junit.basicjunittest;

public class DatabaseConnection {

    private boolean isConnected = false;

    // Establish connection
    public void connect() {
        isConnected = true;
    }

    // Close connection
    public void disconnect() {
        isConnected = false;
    }

    // Return connection status
    public boolean isConnected() {
        return isConnected;
    }
}