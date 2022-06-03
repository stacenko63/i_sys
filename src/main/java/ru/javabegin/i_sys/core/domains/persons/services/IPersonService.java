package ru.javabegin.i_sys.core.domains.persons.services;

import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.persons.Person;

import java.util.ArrayList;

@Service
public interface IPersonService {

    ArrayList<Person> GetPersonsByPage(int page, int size) throws Exception;

    Person GetUserById(int id);

    void CreatePerson(Person person);

    void UpdatePerson(int id, Person person);

    void DeletePerson(int id);

    boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) throws Exception;
}
