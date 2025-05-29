package hu.coolclientmanager.model;

public class Address {
    private String town;
    private String street;
    private String number; // Módosítás: int → String

    public Address(String town, String street, String number) {
        this.town = town;
        this.street = street;
        this.number = number;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }
}