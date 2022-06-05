package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "persons_addresses")
public class PersonAddressDBModel {
    @Id
    private Long addressId;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "person_id")
    private Long personId;

    public PersonAddressDBModel(Long AddressId, String AddressType, Long PersonId) {
        addressId = AddressId;
        addressType = AddressType;
        personId = PersonId;
    }

    public PersonAddressDBModel() {

    }
}
