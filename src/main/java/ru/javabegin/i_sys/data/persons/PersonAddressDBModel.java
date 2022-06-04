package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "persons_addresses")
public class PersonAddressDBModel {
    @Id
    private Long AddressId;

    @Column(name = "address_type")
    private String AddressType;

    @Column(name = "person_id")
    private Long PersonId;

    public PersonAddressDBModel(Long AddressId, String AddressType, Long PersonId) {
        this.AddressId = AddressId;
        this.AddressType = AddressType;
        this.PersonId = PersonId;
    }

    public PersonAddressDBModel() {

    }
}
