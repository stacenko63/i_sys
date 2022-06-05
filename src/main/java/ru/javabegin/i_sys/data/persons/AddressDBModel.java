package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class AddressDBModel {
    @Id
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private int streetNumber;

    @Column(name = "mail_index")
    private String mailIndex;

    public AddressDBModel(Long Id, String City, String Street, int StreetNumber, String MailIndex) {
        id = Id;
        city = City;
        street = Street;
        streetNumber = StreetNumber;
        mailIndex = MailIndex;
    }


    public AddressDBModel() {

    }

    public String GetCity() {
        return city;
    }

    public String GetStreet() {
        return street;
    }

    public int GetStreetNumber() {
        return streetNumber;
    }

    public String GetMailIndex() {
        return mailIndex;
    }
}
