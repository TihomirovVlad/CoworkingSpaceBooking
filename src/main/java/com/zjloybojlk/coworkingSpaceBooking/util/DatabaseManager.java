package com.zjloybojlk.coworkingSpaceBooking.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String USER = "3jloybojlk";
    private static final String PASSWORD = "12345";

    private static Connection connection = null;

    private DatabaseManager() {
    }

    public static Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Established connection with PostgreSQL");
        }
        return connection;
    }

    public static void initializeDataBase() throws SQLException {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {

            stmt.execute("""
                        CREATE TABLE IF NOT EXISTS users (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(50) UNIQUE NOT NULL,
                            password VARCHAR(255) NOT NULL,
                            email VARCHAR(100) UNIQUE NOT NULL,
                            phone VARCHAR(20),
                            role VARCHAR(20) DEFAULT 'USER',
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                        )
                    """);

            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS desks (
                        id SERIAL PRIMARY KEY,
                        deskNumber VARCHAR(10) UNIQUE NOT NULL,
                        description VARCHAR(255),
                        type VARCHAR(20) DEFAULT 'STANDARD',
                        pricePerHour DECIMAL(10,2) NOT NULL,
                        isOccupied BOOLEAN DEFAULT TRUE,
                        createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                    )""");

            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS bookings (
                    id SERIAL PRIMARY KEY,
                    userId INTEGER NOT NULL REFERENCES users(id),
                    deskId INTEGER NOT NULL REFERENCES desks(id),
                    startTime TIMESTAMP NOT NULL,
                    endTime TIMESTAMP NOT NULL,
                    totalPrice DECIMAL(10,2),
                    status VARCHAR(20) DEFAULT 'ACTIVE',
                    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                    CONSTRAINT valid_time CHECK (end_time > start_time)
)
                    """);

        }
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }

    }
}
