package se.nackademin.addressbook.controller;

import org.primefaces.event.RowEditEvent;
import se.nackademin.addressbook.model.Contact;
import se.nackademin.addressbook.service.AddressBookService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Collection;

@ManagedBean(name = "searchController")
@RequestScoped
public class SearchController {

    @ManagedProperty("#{service}")
    private AddressBookService service;
    private String searchQuery = "";
    private Collection<Contact> contacts;

    @PostConstruct
    private void load() {
        setContacts(getSearchQuery());
    }

    // search
    public void search() {
        setContacts(getSearchQuery());
    }

    // Setters
    public void setService(AddressBookService service) {
        this.service = service;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @PostConstruct
    public void setContacts(String searchQuery) {
        this.contacts = service.getContactsMatchingSearchQuery(searchQuery);
    }

    // Getters
    public String getSearchQuery() {
        return searchQuery;
    }

    public Collection<Contact> getContacts() {
        return contacts;
    }

    // Edit contact data
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Contact Edited", ((Contact) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Contact) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
