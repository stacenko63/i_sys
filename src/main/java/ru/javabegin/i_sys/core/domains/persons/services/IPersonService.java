package ru.javabegin.i_sys.core.domains.persons.services;

import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.persons.Person;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

import java.util.ArrayList;

@Service
public interface IPersonService {

    ArrayList<Person> GetPersonsByPage(int page, int size) throws Exception;

    Person GetUserById(int id);

    void CreatePerson(PersonDtoPostOrPut person);

    void UpdatePerson(int id, PersonDtoPostOrPut person);

    void DeletePerson(int id);

    boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) throws Exception;
}
