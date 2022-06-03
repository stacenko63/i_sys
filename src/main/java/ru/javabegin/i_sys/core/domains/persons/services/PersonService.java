package ru.javabegin.i_sys.core.domains.persons.services;

import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.persons.Person;
import ru.javabegin.i_sys.core.domains.persons.repositories.IPersonRepository;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

@Service
public class PersonService implements IPersonService {


    private final IPersonRepository _personRepository;

    public PersonService(IPersonRepository personRepository) {
        _personRepository = personRepository;
    }


    public int GetPersonsByPage(int id, int page) {
        return 5;/////////////////
    }



    public Person GetUserById(int id) {
        return null;///////////
    }



    public void CreatePerson(PersonDtoPostOrPut person) {
///////////////
    }



    public void UpdatePerson(int id, PersonDtoPostOrPut person) {
/////////////////
    }


    public void DeletePerson(int id) {
        _personRepository.DeletePerson(id);
    }

    public boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) {
        return _personRepository.CheckValidPassportByName(name, surname, patronymic, passportValue);
    }


}
