package com.example.contactmanagerui.Model;

public class ContactPerson {
    private int id;
    private String name;
    private String email;
    private String phone;

    private static int contactId;

    public static int getContactId() {
        return contactId;
    }

    public static void setContactId(int contactId) {
        ContactPerson.contactId = contactId;
    }

    private boolean isPrimary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
