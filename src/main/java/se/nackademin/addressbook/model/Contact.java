package se.nackademin.addressbook.model;

public interface Contact {

    void setId(Integer id);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setEmailAddress(String emailAddress);

    void setPhoneNumber(String phoneNumber);

    Integer getId();

    String getFirstName();

    String getLastName();

    String getEmailAddress();

    String getPhoneNumber();

}
