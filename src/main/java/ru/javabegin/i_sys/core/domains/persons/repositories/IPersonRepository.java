package ru.javabegin.i_sys.core.domains.persons.repositories;

import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.persons.PersonDBModel;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

@Repository
public interface IPersonRepository {
    int GetPersonsByPage(int id, int page);

    PersonDBModel GetUserById(int id);

    void CreatePerson(PersonDtoPostOrPut person);

    void UpdatePerson(int id, PersonDtoPostOrPut person);

    void DeletePerson(int id);

    boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue);
}
