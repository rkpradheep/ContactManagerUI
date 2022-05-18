package com.example.contactmanagerui.Model;

public class Contact {
    private int id;
    private String name;
    private String type;
    private String website;
    private Address billing_address;

    private ContactPerson contact_person;

    private int creditLimit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(Address billing_address) {
        this.billing_address = billing_address;
    }


    public ContactPerson getContact_persons() {
        return contact_person;
    }

    public void setContact_persons(ContactPerson contact_persons) {
        this.contact_person = contact_persons;
    }
}
