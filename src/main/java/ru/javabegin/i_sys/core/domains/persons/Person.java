package ru.javabegin.i_sys.core.domains.persons;

import java.util.ArrayList;

public class Person {
    public Person(int Id, String Name, String Surname, String Patronymic, ArrayList<Documents> Documents, ArrayList<Addresses> Addresses, ArrayList<Contacts> Contacts) {
        this.Id = Id;
        this.Name = Name;
        this.Surname = Surname;
        this.Patronymic = Patronymic;
        this.Documents = Documents;
        this.Addresses = Addresses;
        this.Contacts = Contacts;
    }

    public Person(String Name, String Surname, String Patronymic, ArrayList<Documents> Documents, ArrayList<Addresses> Addresses, ArrayList<Contacts> Contacts) {
        this.Name = Name;
        this.Surname = Surname;
        this.Patronymic = Patronymic;
        this.Documents = Documents;
        this.Addresses = Addresses;
        this.Contacts = Contacts;
    }




    public int Id;
    public String Name;
    public String Surname;
    public String Patronymic;

    public ArrayList<Documents> Documents;
    public ArrayList<Addresses> Addresses;
    public ArrayList<Contacts> Contacts;




    public static class Documents {
        public Documents(int Id, String DocumentType, String Value) {
            this.Id = Id;
            this.DocumentType = DocumentType;
            this.Value = Value;
        }

        public Documents(String DocumentType, String Value) {
            this.DocumentType = DocumentType;
            this.Value = Value;
        }
        public int Id;
        public String DocumentType;
        public String Value;
    }

    public static class Addresses {
        public Addresses (int Id, String AddressType, String City, String Street, String StreetNumber, String MailIndex) {
            this.Id = Id;
            this.AddressType = AddressType;
            this.City = City;
            this.Street = Street;
            this.StreetNumber = StreetNumber;
            this.MailIndex = MailIndex;
        }

        public Addresses (String AddressType, String City, String Street, String StreetNumber, String MailIndex) {
            this.AddressType = AddressType;
            this.City = City;
            this.Street = Street;
            this.StreetNumber = StreetNumber;
            this.MailIndex = MailIndex;
        }
        public int Id;
        public String AddressType;
        public String City;
        public String Street;
        public String StreetNumber;
        public String MailIndex;
    }

    public static class Contacts {

        public Contacts(int Id, String ContactType, String Contact) {
            this.Id = Id;
            this.ContactType = ContactType;
            this.Contact = Contact;
        }

        public Contacts(String ContactType, String Contact) {
            this.ContactType = ContactType;
            this.Contact = Contact;
        }

        public int Id;
        public String ContactType;
        public String Contact;

    }
}
