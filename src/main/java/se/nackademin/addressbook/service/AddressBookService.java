package se.nackademin.addressbook.service;

import se.nackademin.addressbook.model.Contact;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Singleton
@ApplicationScoped
@ManagedBean(name = "service")
public class AddressBookService {
    private Integer id = 0;
    private Map<Integer, Contact> contactMap = new HashMap<Integer, Contact>();

    // Contact map modification functions
    public void add(Contact contactDetails) {
        contactDetails.setId(this.id++);
        contactMap.put(contactDetails.getId(), contactDetails);
    }

    public void delete(Integer id) {
        contactMap.remove(id);
    }

    // Getters
    public Collection<Contact> getAllContacts() {
        if (contactMap != null) {
            return contactMap.values();
        } else {
            contactMap = new HashMap<>();
            return contactMap.values();
        }
    }

    public Collection<Contact> getContactsMatchingSearchQuery(String searchQuery) {
        return contactMap
                .values()
                .stream()
                .filter(
                        contact -> (contact.getFirstName() != null && contact.getFirstName().contains(searchQuery))
                                || (contact.getLastName() != null && contact.getLastName().contains(searchQuery))
                                || (contact.getEmailAddress() != null && contact.getEmailAddress().contains(searchQuery))
                                || (contact.getPhoneNumber() != null && contact.getPhoneNumber().contains(searchQuery)))
                .collect(toList());
    }

}
