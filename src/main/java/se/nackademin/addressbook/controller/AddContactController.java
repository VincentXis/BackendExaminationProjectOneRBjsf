package se.nackademin.addressbook.controller;

import se.nackademin.addressbook.model.Contact;
import se.nackademin.addressbook.model.ContactDetails;
import se.nackademin.addressbook.service.AddressBookService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddContactController {
    @Inject
    private AddressBookService service;
    private Contact contact;
    private String message = "";

    public void addContact() {
        if (validateInput()) {
            service.add(getContact());
            setMessage("Contact added");
            clearFields();
        } else {
            setMessage("Failed to add contact, all fields must be filled");
        }
    }
    public void clearFields(){
        contact = null;
    }

    public boolean validateInput() {
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

    public String getValidatorMessage(){
        return "Field must contain at least two characters:";
    }
    public String getRequiredMessage() {
        return "Field has not been set:";
    }

}
