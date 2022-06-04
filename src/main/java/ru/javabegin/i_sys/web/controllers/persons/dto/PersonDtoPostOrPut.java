package ru.javabegin.i_sys.web.controllers.persons.dto;

import ru.javabegin.i_sys.core.domains.persons.Person;

import java.util.ArrayList;

public class PersonDtoPostOrPut {
    public String Name;
    public String Surname;
    public String Patronymic;

    public ArrayList<DocumentsDtoPostOrPut> Documents;
    public ArrayList<AddressesDtoPostOrPut> Addresses;
    public ArrayList<ContactsDtoPostOrPut> Contacts;

    public Person ConvertToCoreModel() {


        var newDocuments = new ArrayList<Person.Documents>();
        for (var el: Documents) {
            newDocuments.add(new Person.Documents(el.DocumentType, el.Value));
        }


        var newAddresses = new ArrayList<Person.Addresses>();
        for (var el: Addresses) {
            newAddresses.add(new Person.Addresses(el.AddressType, el.City, el.Street, el.StreetNumber, el.MailIndex));
        }


        var newContacts = new ArrayList<Person.Contacts>();
        for (var el: Contacts) {
            newContacts.add(new Person.Contacts(el.ContactType, el.Contact));
        }

        return new Person(Name, Surname, Patronymic, newDocuments, newAddresses, newContacts);

    }


    public class DocumentsDtoPostOrPut {
        public String DocumentType;
        public String Value;
    }

    public class AddressesDtoPostOrPut {
        public String AddressType;
        public String City;
        public String Street;
        public int StreetNumber;
        public String MailIndex;
    }

    public class ContactsDtoPostOrPut {
        public String ContactType;
        public String Contact;

    }

}


