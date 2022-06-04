package ru.javabegin.i_sys.data.persons;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@EnableJpaRepositories
public class PersonDBModel {
    @Id
    private Long Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "surname")
    private String Surname;

    @Column(name = "patronymic")
    private String Patronymic;

    public PersonDBModel(Long Id, String Name, String Surname, String Patronymic) {
        this.Id = Id;
        this.Name = Name;
        this.Surname = Surname;
        this.Patronymic = Patronymic;
    }

    public PersonDBModel() {

    }

    public Long GetId() {
        return Id;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }

    public String GetName() {
        return Name;
    }

    public void SetSurname(String Surname) {
        this.Name = Name;
    }

    public String GetSurname() {
        return Name;
    }

    public void SetPatronymic(String Patronymic) {
        this.Name = Name;
    }

    public String GetPatronymic() {
        return Name;
    }




}
