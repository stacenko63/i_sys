package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class ContactDBModel {
    @Id
    private Long id;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "contact")
    private String contact;

    @Column(name = "person_id")
    private Long personId;

    public ContactDBModel(Long Id, String ContactType, String Contact, Long PersonId) {
        id = Id;
        contactType = ContactType;
        contact = Contact;
        personId = PersonId;
    }

    public ContactDBModel() {

    }

    public Long GetId() {
        return id;
    }

    public String GetContactType() {
        return contactType;
    }

    public String GetContact() {
        return contact;
    }

}
