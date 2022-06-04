package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class ContactDBModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "contact_type")
    private String ContactType;

    @Column(name = "contact")
    private String Contact;

    @Column(name = "person_id")
    private Long PersonId;

    public ContactDBModel(String ContactType, String Contact, Long PersonId) {
        this.ContactType = ContactType;
        this.Contact = Contact;
        this.PersonId = PersonId;
    }

    public ContactDBModel() {

    }
}
