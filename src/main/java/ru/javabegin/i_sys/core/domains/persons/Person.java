package ru.javabegin.i_sys.core.domains.persons;

import java.util.ArrayList;

public class Person {

    public static Long GenerateId = Long.valueOf(1);


    public Person(String Name, String Surname, String Patronymic, ArrayList<Documents> Documents, ArrayList<Addresses> Addresses, ArrayList<Contacts> Contacts) {
        Id = GenerateId;
        GenerateId++;
        this.Name = Name;
        this.Surname = Surname;
        this.Patronymic = Patronymic;
        this.Documents = Documents;
        this.Addresses = Addresses;
        this.Contacts = Contacts;
    }




    public Long Id;
    public String Name;
    public String Surname;
    public String Patronymic;

    public ArrayList<Documents> Documents;
    public ArrayList<Addresses> Addresses;
    public ArrayList<Contacts> Contacts;




    public static class Documents {
        public Documents(Long Id, String DocumentType, String Value) {
            this.Id = Id;
            this.DocumentType = DocumentType;
            this.Value = Value;
        }

        public Documents(String DocumentType, String Value) {
            this.DocumentType = DocumentType;
            this.Value = Value;
        }
        public Long Id;
        public String DocumentType;
        public String Value;
    }

    public static class Addresses {
        private static Long GenerateAddressId = Long.valueOf(1);
        public Addresses (Long Id, String AddressType, String City, String Street, int StreetNumber, String MailIndex) {
            this.Id = Id;
            this.AddressType = AddressType;
            this.City = City;
            this.Street = Street;
            this.StreetNumber = StreetNumber;
            this.MailIndex = MailIndex;
        }

        public Addresses (String AddressType, String City, String Street, int StreetNumber, String MailIndex) {
            Id = GenerateAddressId;
            GenerateAddressId++;
            this.AddressType = AddressType;
            this.City = City;
            this.Street = Street;
            this.StreetNumber = StreetNumber;
            this.MailIndex = MailIndex;
        }
        public Long Id;
        public String AddressType;
        public String City;
        public String Street;
        public int StreetNumber;
        public String MailIndex;
    }

    public static class Contacts {

        public Contacts(Long Id, String ContactType, String Contact) {
            this.Id = Id;
            this.ContactType = ContactType;
            this.Contact = Contact;
        }

        public Contacts(String ContactType, String Contact) {
            this.ContactType = ContactType;
            this.Contact = Contact;
        }

        public Long Id;
        public String ContactType;
        public String Contact;

    }
}
