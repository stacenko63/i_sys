package ru.javabegin.i_sys.data.persons;

//import javax.persistence.*;

//@Entity
//@Table(name = "persons")
public class PersonDBModel {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    //@Column(name = "name")
    public String Name;

    //@Column(name = "surname")
    public String Surname;

    //@Column(name = "patronymic")
    public String Patronymic;
}
