package ru.javabegin.i_sys.core.domains.persons;

import java.util.ArrayList;

public class Person {
    public int Id;
    public String Name;
    public String Surname;
    public String Patronymic;

    public ArrayList<Documents> Documents;
    public ArrayList<Addresses> Addresses;
    public ArrayList<Contacts> Contacts;




    public class Documents {
        public int Id;
        public String DocumentType;
        public String Value;
    }

    public class Addresses {
        public int Id;
        public String AddressType;
        public String City;
        public String Street;
        public String StreetNumber;
        public String MailIndex;
    }

    public class Contacts {
        public int Id;
        public String ContactType;
        public String Contact;

    }
}
