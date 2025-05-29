package hu.coolclientmanager.ui;

import hu.coolclientmanager.model.Address;
import hu.coolclientmanager.model.Customer;
import hu.coolclientmanager.repository.CustomerRepository;
import hu.coolclientmanager.repository.DatabaseInitializer;

import java.util.List;
import java.util.Scanner;

public class ConsoleApp {

    private final CustomerRepository customerRepository = new CustomerRepository();
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleApp() {
        DatabaseInitializer.initializeDatabase(); // Adatbázis inicializálás
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nÜdv a CoolClientManager-ben! Válassz egy műveletet:");
            System.out.println("1 - Ügyfél hozzáadása");
            System.out.println("2 - Ügyfelek listázása");
            System.out.println("3 - Ügyfél törlése");
            System.out.println("0 - Kilépés");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter kezelés

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> listCustomers();
                case 3 -> deleteCustomer();
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
        String number = scanner.nextLine(); // Most már String formátumú

        Address address = new Address(town, street, number);
        Customer customer = new Customer(0, name, taxNumber, address);

        customerRepository.saveCustomer(customer);
        System.out.println("✅ Ügyfél elmentve az adatbázisba!");
    }

    private void listCustomers() {
        List<Customer> customers = customerRepository.loadCustomers();
        System.out.println("\n📋 Ügyfelek listája:");
        for (Customer customer : customers) {
            System.out.println(customer.getId() + " - " + customer.getCompanyName() + " | Adószám: " + customer.getTaxNumber());
        }
    }

    private void deleteCustomer() {
        System.out.print("Törlendő ügyfél ID: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Enter kezelés

        customerRepository.deleteCustomer(id);

    }

    public static void main(String[] args) {
        new ConsoleApp().start();
    }
}