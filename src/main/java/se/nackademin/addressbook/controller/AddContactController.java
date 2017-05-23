package se.nackademin.addressbook.controller;

import se.nackademin.addressbook.model.Contact;
import se.nackademin.addressbook.model.ContactDetails;
import se.nackademin.addressbook.service.AddressBookService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "addContactController")
@RequestScoped
public class AddContactController {
    @ManagedProperty("#{service}")
    private AddressBookService service;
    private Contact contact;
    private String message = "";

    // Add new contact
    public void addContact() {
        if (validateInput()) {
            service.add(getContact());
            setMessage("Contact added");
            clearFields();
        } else {
            setMessage("Failed to add contact, all fields must be filled");
        }
    }

    // Clear form fields
    public void clearFields() {
        contact = null;
    }

    // Validate input, null check and empty check
    private boolean validateInput() {
        return (getContact().getFirstName() != null && !getContact().getFirstName().trim().isEmpty()) &&
                (getContact().getLastName() != null && !getContact().getLastName().trim().isEmpty()) &&
                (getContact().getEmailAddress() != null && !getContact().getEmailAddress().trim().isEmpty()) &&
                (getContact().getPhoneNumber() != null && !getContact().getPhoneNumber().trim().isEmpty());
    }

    // Setters
    public void setService(AddressBookService service) {
        this.service = service;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getters
    public Contact getContact() {
        if (this.contact == null) {
            this.contact = new ContactDetails();
        }
        return this.contact;
    }

    public String getMessage() {
        return message;
    }

    public String getValidatorMessage() {
        return "Field must contain at least two characters:";
    }

    public String getRequiredMessage() {
        return "Field has not been set:";
    }

}
