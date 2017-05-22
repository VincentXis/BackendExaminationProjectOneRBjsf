package se.nackademin.addressbook.service;

import se.nackademin.addressbook.model.Contact;

import javax.ejb.Singleton;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Singleton
public class AddressBookService implements Serializable{
    private Integer id = 0;
    private Map<Integer, Contact> contactMap = new HashMap<>();

    public void add(Contact contactDetails) {
        contactDetails.setId(this.id++);
        contactMap.put(contactDetails.getId(), contactDetails);
    }

    public void delete(Integer id) {
        contactMap.remove(id);
    }

    public Collection<Contact> getAllContacts() {
        return contactMap.values();
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

    // Todo: get contact by id, for updating purposes

}
