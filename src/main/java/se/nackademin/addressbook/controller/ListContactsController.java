package se.nackademin.addressbook.controller;

import org.primefaces.push.annotation.PathParam;
import se.nackademin.addressbook.model.Contact;
import se.nackademin.addressbook.model.ContactDetails;
import se.nackademin.addressbook.service.AddressBookService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

@Named
@RequestScoped
public class ListContactsController implements Serializable {
    @Inject
    private AddressBookService service;

    public Collection<Contact> getContacts() {
        return service.getAllContacts();
    }
}
