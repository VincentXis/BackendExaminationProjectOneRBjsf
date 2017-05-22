package se.nackademin.addressbook.controller;

import org.primefaces.event.RowEditEvent;
import se.nackademin.addressbook.model.Contact;
import se.nackademin.addressbook.service.AddressBookService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Collection;

@ManagedBean(name = "searchController")
@RequestScoped
public class SearchController {

    @Inject
    private AddressBookService service;
    private String searchQuery = "";
    private Collection<Contact> contacts;

    @PostConstruct
    private void load(){
        setContacts(getSearchQuery());
    }
    // search
    public void search(){
        setContacts(getSearchQuery());
    }

    // Set
    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public void setContacts(String searchQuery) {
        this.contacts = service.getContactsMatchingSearchQuery(searchQuery);
    }

    // Get
    public String getSearchQuery() {
        return searchQuery;
    }

    public Collection<Contact> getContacts() {
        return contacts;
    }

    // Edit
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Contact Edited", ((Contact) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Contact) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
