package hu.coolclientmanager.ui;

import hu.coolclientmanager.model.Customer;
import hu.coolclientmanager.model.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private List<Customer> customers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nÜdv a CoolClientManager-ben! Válassz egy műveletet:");
            System.out.println("1 - Ügyfél hozzáadása");
            System.out.println("2 - Ügyfelek listázása");
            System.out.println("0 - Kilépés");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter kezelés

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> listCustomers();
                case 0 -> running = false;
                default -> System.out.println("Érvénytelen választás, próbáld újra.");
            }
        }
    }

    private void addCustomer() {
        System.out.print("Cég neve: ");
        String name = scanner.nextLine();

        System.out.print("Adószám: ");
        String taxNumber = scanner.nextLine();

        System.out.print("Város: ");
        String town = scanner.nextLine();

        System.out.print("Utca: ");
        String street = scanner.nextLine();

        System.out.print("Házszám: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Enter kezelés

        Address address = new Address(town, street, number);
        Customer customer = new Customer(customers.size() + 1, name, taxNumber, address);
        customers.add(customer);

        System.out.println("✅ Ügyfél hozzáadva!");
    }

    private void listCustomers() {
        System.out.println("\n📋 Ügyfelek listája:");
        for (Customer customer : customers) {
            System.out.println(customer.getCompanyName() + " | Adószám: " + customer.getTaxNumber());
        }
    }

    public static void main(String[] args) {
        new ConsoleApp().start();
    }
}