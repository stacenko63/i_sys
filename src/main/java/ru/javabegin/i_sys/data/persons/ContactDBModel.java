package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class ContactDBModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "contact")
    private String contact;

    @Column(name = "person_id")
    private Long personId;

    public ContactDBModel(String ContactType, String Contact, Long PersonId) {
        contactType = ContactType;
        contact = Contact;
        personId = PersonId;
    }

    public ContactDBModel() {

    }
}
