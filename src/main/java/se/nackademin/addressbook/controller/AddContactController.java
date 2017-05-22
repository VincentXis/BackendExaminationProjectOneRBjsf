package se.nackademin.addressbook.controller;

import se.nackademin.addressbook.model.Contact;
import se.nackademin.addressbook.model.ContactDetails;
import se.nackademin.addressbook.service.AddressBookService;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean(name = "addContactController")
@RequestScoped
public class AddContactController {
    @Inject
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
                (getContact().getFirstName() != null && !getContact().getFirstName().trim().isEmpty()) &&
                (getContact().getFirstName() != null && !getContact().getFirstName().trim().isEmpty()) &&
                (getContact().getFirstName() != null && !getContact().getFirstName().trim().isEmpty());
    }

    // Set
    public void setMessage(String message) {
        this.message = message;
    }

    // Get
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
