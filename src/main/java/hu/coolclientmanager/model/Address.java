package hu.coolclientmanager.model;

public class Address {
    private String town;
    private String street;
    private int number;

    public Address(String town, String street, int number) {
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

    public int getNumber() {
        return number;
    }
}