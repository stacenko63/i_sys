package ru.javabegin.i_sys.web.controllers.persons.dto;

import java.util.ArrayList;

public class PersonDtoPostOrPut {
    public String Name;
    public String Surname;
    public String Patronymic;

    public ArrayList<DocumentsDtoPostOrPut> Documents;
    public ArrayList<AddressesDtoPostOrPut> Addresses;
    public ArrayList<ContactsDtoPostOrPut> Contacts;




    public class DocumentsDtoPostOrPut {
        public String DocumentType;
        public String Value;
    }

    public class AddressesDtoPostOrPut {
        public String AddressType;
        public String City;
        public String Street;
        public String StreetNumber;
        public String MailIndex;
    }

    public class ContactsDtoPostOrPut {
        public String ContactType;
        public String Contact;

    }

}


