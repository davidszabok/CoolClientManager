package hu.coolclientmanager.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private static final String DB_URL = "jdbc:h2:file:./coolclientmanager_db;AUTO_SERVER=TRUE;CACHE_SIZE=1024;MODE=MySQL";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String createTableSQL = """
                        CREATE TABLE IF NOT EXISTS customers (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            company_name VARCHAR(255),
                            tax_number VARCHAR(20),
                            town VARCHAR(100),
                            street VARCHAR(100),
                            number VARCHAR(20)  -- Módosítás: INT → VARCHAR(20)
                        )
                    """;
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}