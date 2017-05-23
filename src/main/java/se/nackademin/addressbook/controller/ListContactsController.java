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

@ManagedBean(name = "listContactsController")
@RequestScoped
public class ListContactsController {

    @ManagedProperty("#{service}")
    private AddressBookService service;

    // Setters
    public void setService(AddressBookService service) {
        this.service = service;
    }

    // Getters
    public Collection<Contact> getContacts() {
        return service.getAllContacts();
    }

    // Delete contact
    public void deleteContact(Integer id) {
        service.delete(id);
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
