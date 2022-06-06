package ru.javabegin.i_sys.data.medicals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccines")
public class VaccineDBModel {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;
}
