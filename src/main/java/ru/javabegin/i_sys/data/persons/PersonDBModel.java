package ru.javabegin.i_sys.data.persons;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@EnableJpaRepositories
public class PersonDBModel {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    public PersonDBModel(Long Id, String Name, String Surname, String Patronymic) {
        id = Id;
        name = Name;
        surname = Surname;
        patronymic = Patronymic;
    }

    public PersonDBModel() {

    }

    public Long GetId() {
        return id;
    }

    public void SetName(String Name) {
        name = Name;
    }

    public String GetName() {
        return name;
    }

    public void SetSurname(String Surname) {
        surname = Surname;
    }

    public String GetSurname() {
        return surname;
    }

    public void SetPatronymic(String Patronymic) {
        patronymic = Patronymic;
    }

    public String GetPatronymic() {
        return patronymic;
    }




}
