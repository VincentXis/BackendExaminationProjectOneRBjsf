package se.nackademin.addressbook.controller;

import se.nackademin.addressbook.model.Contact;
import se.nackademin.addressbook.model.ContactDetails;
import se.nackademin.addressbook.service.AddressBookService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class ListContactsController implements Serializable {
    @Inject
    private AddressBookService service;
//    @PostConstruct
//    private void load(){
//        service.add(new ContactDetails("wawa","gaga","mail","123"));
//        service.add(new ContactDetails("lala","sasa","mail","123"));
//        service.add(new ContactDetails("gogo","nono","mail","123"));
//    }

    public Collection<Contact> getContacts() {
        return service.getAllContacts();
    }

}
