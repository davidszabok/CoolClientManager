package hu.coolclientmanager.repository;

import hu.coolclientmanager.model.Address;
import hu.coolclientmanager.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final String DB_URL = "jdbc:h2:file:./coolclientmanager_db;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public void saveCustomer(Customer customer) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("""
                         INSERT INTO customers (company_name, tax_number, town, street, number)
                         VALUES (?, ?, ?, ?, ?)
                     """)) {
            pstmt.setString(1, customer.getCompanyName());
            pstmt.setString(2, customer.getTaxNumber());
            pstmt.setString(3, customer.getBillingAddress().getTown());
            pstmt.setString(4, customer.getBillingAddress().getStreet());
            pstmt.setInt(5, customer.getBillingAddress().getNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM customers")) {

            while (rs.next()) {
                Address address = new Address(rs.getString("town"), rs.getString("street"), rs.getInt("number"));
                Customer customer = new Customer(rs.getLong("id"), rs.getString("company_name"), rs.getString("tax_number"), address);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void deleteCustomer(long customerId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM customers WHERE id = ?")) {
            pstmt.setLong(1, customerId);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("✅ Ügyfél törölve!");
            } else {
                System.out.println("⚠️ Ügyfél nem található.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}