package ru.javabegin.i_sys.web.controllers.persons.dto;

import ru.javabegin.i_sys.core.domains.persons.Person;

import java.util.ArrayList;

public class PersonDtoGet {

        public int Id;
        public String Name;
        public String Surname;
        public String Patronymic;

        public ArrayList<DocumentsDtoGet> Documents;
        public ArrayList<AddressesDtoGet> Addresses;
        public ArrayList<ContactsDtoGet> Contacts;


        public PersonDtoGet (Person person) {

            var newDocuments = new ArrayList<DocumentsDtoGet>();
            for (var el: person.Documents) {
                newDocuments.add(new DocumentsDtoGet(el));
            }


            var newAddresses = new ArrayList<AddressesDtoGet>();
            for (var el: person.Addresses) {
                newAddresses.add(new AddressesDtoGet(el));
            }


            var newContacts = new ArrayList<ContactsDtoGet>();
            for (var el: person.Contacts) {
                newContacts.add(new ContactsDtoGet(el));
            }

            this.Id = person.Id;
            this.Name = person.Name;
            this.Surname = person.Surname;
            this.Patronymic = person.Patronymic;
            this.Documents = newDocuments;

        }



        public class DocumentsDtoGet {

            public DocumentsDtoGet(Person.Documents documents) {
                this.Id = documents.Id;
                this.DocumentType = documents.DocumentType;
                this.Value = documents.Value;
            }

            public int Id;
            public String DocumentType;
            public String Value;
        }

        public class AddressesDtoGet {
            public AddressesDtoGet(Person.Addresses addresses) {
                this.Id = addresses.Id;
                this.AddressType = addresses.AddressType;
                this.City = addresses.City;
                this.Street = addresses.Street;
                this.StreetNumber = addresses.StreetNumber;
                this.MailIndex = addresses.MailIndex;
            }

            public int Id;
            public String AddressType;
            public String City;
            public String Street;
            public String StreetNumber;
            public String MailIndex;
        }

        public class ContactsDtoGet {
            public ContactsDtoGet(Person.Contacts contacts) {
                this.Id = contacts.Id;
                this.ContactType = contacts.ContactType;
                this.Contact = contacts.Contact;
            }

            public int Id;
            public String ContactType;
            public String Contact;

        }



}
