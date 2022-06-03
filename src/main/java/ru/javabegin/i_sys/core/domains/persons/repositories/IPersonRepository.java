package ru.javabegin.i_sys.core.domains.persons.repositories;

import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.core.domains.persons.Person;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

import java.util.ArrayList;

@Repository
public interface IPersonRepository {
    ArrayList<Person> GetPersonsByPage(int page, int size);

    Person GetUserById(int id);

    void CreatePerson(PersonDtoPostOrPut person);

    void UpdatePerson(int id, PersonDtoPostOrPut person);

    void DeletePerson(int id);

    boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue);
}
