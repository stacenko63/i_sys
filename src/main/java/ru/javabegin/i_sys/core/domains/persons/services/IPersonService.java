package ru.javabegin.i_sys.core.domains.persons.services;

import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.persons.Person;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

@Service
public interface IPersonService {

    //int GetPersonsByPage(int id, int page);

    Person GetUserById(int id);

    void CreatePerson(PersonDtoPostOrPut person);

    void UpdatePerson(int id, PersonDtoPostOrPut person);

    void DeletePerson(int id);

    boolean CheckValidPassportByName(String name, String surname, String patronymic);
}
