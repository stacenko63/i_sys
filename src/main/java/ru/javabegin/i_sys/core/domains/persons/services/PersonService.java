package ru.javabegin.i_sys.core.domains.persons.services;

import ru.javabegin.i_sys.core.domains.persons.Person;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

public class PersonService implements IPersonService {


    /*private final IPersonRepository _personRepository;

    public PersonService(IPersonRepository personRepository) {
        _personRepository = personRepository;
    }*/


    public int GetPersonsByPage(int id, int page) {
        return 5;/////////////////
    }



    public Person GetUserById(int id) {
        return null;
    }

    //добавление данных о гражданине

    public void CreatePerson(PersonDtoPostOrPut person) {

    }

    //редактирование данных о гражданине

    public void UpdatePerson(int id, PersonDtoPostOrPut person) {

    }

    //удаление данных о гражданине
    public void DeletePerson(int id) {

    }

    @Override
    public boolean CheckValidPassportByName(String name, String surname, String patronymic) {
        return false;
    }


}
