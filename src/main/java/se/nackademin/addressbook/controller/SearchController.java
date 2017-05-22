package se.nackademin.addressbook.controller;

import com.sun.deploy.net.HttpRequest;
import se.nackademin.addressbook.model.Contact;
import se.nackademin.addressbook.service.AddressBookService;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Map;

@ManagedBean(name = "searchController")
@RequestScoped
public class SearchController {

    @Inject
    private AddressBookService service;
    private String searchQuery;
    private Collection<Contact> contacts;


    public void search() {
        contacts = service.getContactsMatchingSearchQuery(searchQuery);
    }


    public Collection<Contact> getContacts() {
        return contacts;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
}
