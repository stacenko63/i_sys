package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class PersonDBModel {
    @Id
    private Long Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "surname")
    private String Surname;

    @Column(name = "patronymic")
    public String Patronymic;

    public PersonDBModel(Long Id, String Name, String Surname, String Patronymic) {
        this.Id = Id;
        this.Name = Name;
        this.Surname = Surname;
        this.Patronymic = Patronymic;
    }

    public PersonDBModel() {

    }
}
