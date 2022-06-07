package ru.javabegin.i_sys.data.medicals;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "vaccination_centres")
public class VaccinationCenterDBModel {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    public String GetName() {
        return name;
    }

    public String GetAddress() {
        return address;
    }

    public Long GetId() {
        return id;
    }
}
