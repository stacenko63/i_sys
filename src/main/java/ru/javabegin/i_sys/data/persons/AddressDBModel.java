package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class AddressDBModel {
    @Id
    private Long Id;

    @Column(name = "city")
    private String City;

    @Column(name = "street")
    private String Street;

    @Column(name = "street_number")
    private int StreetNumber;

    @Column(name = "mail_index")
    private String MailIndex;

    public AddressDBModel(Long Id, String City, String Street, int StreetNumber, String MailIndex) {
        this.Id = Id;
        this.City = City;
        this.Street = Street;
        this.StreetNumber = StreetNumber;
        this.MailIndex = MailIndex;
    }


    public AddressDBModel() {

    }
}
