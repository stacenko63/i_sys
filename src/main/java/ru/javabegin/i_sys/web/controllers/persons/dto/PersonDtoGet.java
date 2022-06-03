package ru.javabegin.i_sys.web.controllers.persons.dto;

import java.util.ArrayList;

public class PersonDtoGet {

        public int Id;
        public String Name;
        public String Surname;
        public String Patronymic;

        public ArrayList<DocumentsDtoGet> Documents;
        public ArrayList<AddressesDtoGet> Addresses;
        public ArrayList<ContactsDtoGet> Contacts;




        public class DocumentsDtoGet {
            public int Id;
            public String DocumentType;
            public String Value;
        }

        public class AddressesDtoGet {
            public int Id;
            public String AddressType;
            public String City;
            public String Street;
            public String StreetNumber;
            public String MailIndex;
        }

        public class ContactsDtoGet {
            public int Id;
            public String ContactType;
            public String Contact;

        }



}
