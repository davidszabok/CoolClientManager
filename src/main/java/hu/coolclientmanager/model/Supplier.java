package hu.coolclientmanager.model;

import java.util.List;

public class Supplier {
    private long id;
    private String companyName;
    private String taxNumber;
    private Address companyAddress;
    private List<ContactPerson> contactPersons;

    public Supplier(long id, String companyName, String taxNumber, Address companyAddress) {
        this.id = id;
        this.companyName = companyName;
        this.taxNumber = taxNumber;
        this.companyAddress = companyAddress;
    }

    // Getterek és setterek
    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public List<ContactPerson> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(List<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }
}