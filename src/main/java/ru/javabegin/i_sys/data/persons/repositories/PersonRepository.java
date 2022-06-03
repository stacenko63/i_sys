package ru.javabegin.i_sys.data.persons.repositories;

import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.core.domains.persons.repositories.IPersonRepository;
import ru.javabegin.i_sys.data.persons.PersonDBModel;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

@Repository
public class PersonRepository implements IPersonRepository {


    public int GetPersonsByPage(int id, int page) {
        return 0;///////////////
    }


    public PersonDBModel GetUserById(int id) {
        return null;////////
    }


    public void CreatePerson(PersonDtoPostOrPut person) {
////////////
    }


    public void UpdatePerson(int id, PersonDtoPostOrPut person) {
///////////
    }


    public void DeletePerson(int id) {
//////////////
    }

    public boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) {
        return false;///////
    }
}
