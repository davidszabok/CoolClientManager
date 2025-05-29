package hu.coolclientmanager.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    @Test
    void getId() {
        Address address = new Address("Budapest", "Fő utca", 10);
        Customer customer = new Customer(1, "Tesla Hungary Kft.", "12345678", address);
        assertEquals(1, customer.getId());
    }

    @Test
    void getCompanyName() {
        Address address = new Address("Budapest", "Fő utca", 10);
        Customer customer = new Customer(1, "Tesla Hungary Kft.", "12345678", address);
        assertEquals("Tesla Hungary Kft.", customer.getCompanyName());
    }

    @Test
    void getTaxNumber() {
        Address address = new Address("Budapest", "Fő utca", 10);
        Customer customer = new Customer(1, "Tesla Hungary Kft.", "12345678", address);
        assertEquals("12345678", customer.getTaxNumber());
    }

    @Test
    void getBillingAddress() {
        Address address = new Address("Budapest", "Fő utca", 10);
        Customer customer = new Customer(1, "Tesla Hungary Kft.", "12345678", address);
        assertEquals(address, customer.getBillingAddress());
    }

    @Test
    void setShippingAddresses() {
        Address address1 = new Address("Szeged", "Tisza utca", 5);
        Address address2 = new Address("Debrecen", "Kossuth tér", 12);
        Customer customer = new Customer(1, "Tesla Hungary Kft.", "12345678", new Address("Budapest", "Fő utca", 10));
        customer.setShippingAddresses(List.of(address1, address2));
        assertEquals(2, customer.getShippingAddresses().size());
    }

    @Test
    void getShippingAddresses() {
        Address address1 = new Address("Szeged", "Tisza utca", 5);
        Address address2 = new Address("Debrecen", "Kossuth tér", 12);
        Customer customer = new Customer(1, "Tesla Hungary Kft.", "12345678", new Address("Budapest", "Fő utca", 10));
        customer.setShippingAddresses(List.of(address1, address2));
        assertTrue(customer.getShippingAddresses().contains(address1));
        assertTrue(customer.getShippingAddresses().contains(address2));
    }

    @Test
    void setContactPersons() {
        ContactPerson person1 = new ContactPerson("János Nagy", "janos@example.com", "+36201234567");
        ContactPerson person2 = new ContactPerson("Anna Kiss", "anna@example.com", "+36209876543");
        Customer customer = new Customer(1, "Tesla Hungary Kft.", "12345678", new Address("Budapest", "Fő utca", 10));
        customer.setContactPersons(List.of(person1, person2));
        assertEquals(2, customer.getContactPersons().size());
    }

    @Test
    void getContactPersons() {
        ContactPerson person1 = new ContactPerson("János Nagy", "janos@example.com", "+36201234567");
        ContactPerson person2 = new ContactPerson("Anna Kiss", "anna@example.com", "+36209876543");
        Customer customer = new Customer(1, "Tesla Hungary Kft.", "12345678", new Address("Budapest", "Fő utca", 10));
        customer.setContactPersons(List.of(person1, person2));
        assertTrue(customer.getContactPersons().contains(person1));
        assertTrue(customer.getContactPersons().contains(person2));
    }
}