package se.nackademin.addressbook.controller;

import org.primefaces.event.RowEditEvent;
import se.nackademin.addressbook.model.Contact;
import se.nackademin.addressbook.service.AddressBookService;

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

    // search
    public void search() {
    }

    // Setters
    public void setService(AddressBookService service) {
        this.service = service;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    // Getters
    public String getSearchQuery() {
        return searchQuery;
    }

    public Collection<Contact> getContacts() {
        return service.getContactsMatchingSearchQuery(getSearchQuery());
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
