package hu.coolclientmanager.model;

import java.util.List;

public class Customer {
    private long id;
    private String companyName;
    private String taxNumber;
    private Address billingAddress;
    private List<Address> shippingAddresses;
    private List<ContactPerson> contactPersons;

    public Customer(long id, String companyName, String taxNumber, Address billingAddress) {
        this.id = id;
        this.companyName = companyName;
        this.taxNumber = taxNumber;
        this.billingAddress = billingAddress;
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

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setShippingAddresses(List<Address> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }

    public List<Address> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setContactPersons(List<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public List<ContactPerson> getContactPersons() {
        return contactPersons;
    }
}