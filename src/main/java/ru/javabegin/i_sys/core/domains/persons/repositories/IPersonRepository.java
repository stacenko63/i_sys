package ru.javabegin.i_sys.core.domains.persons.repositories;

import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.core.domains.persons.Person;

import java.util.ArrayList;

@Repository
public interface IPersonRepository {
    ArrayList<Person> GetPersonsByPage(int page, int size);

    Person GetUserById(int id);

    void CreatePerson(Person person);

    void UpdatePerson(int id, Person person);

    void DeletePerson(int id);

    boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue);

}
