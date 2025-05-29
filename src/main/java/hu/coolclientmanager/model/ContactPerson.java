package hu.coolclientmanager.model;

public class ContactPerson {
    private String name;
    private String email;
    private String phoneNumber;

    public ContactPerson(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getterek
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}