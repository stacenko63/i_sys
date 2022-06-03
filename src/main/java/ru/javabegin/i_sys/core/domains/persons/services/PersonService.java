package ru.javabegin.i_sys.core.domains.persons.services;

import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.persons.Person;
import ru.javabegin.i_sys.core.domains.persons.repositories.IPersonRepository;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

import java.util.ArrayList;

@Service
public class PersonService implements IPersonService {


    private final IPersonRepository _personRepository;

    public PersonService(IPersonRepository personRepository) {
        _personRepository = personRepository;
    }


    public ArrayList<Person> GetPersonsByPage(int page, int size) throws Exception {
        if (page < 1) throw new Exception("Номер страницы должен быть не меньше 1!");
        if (size < 1) throw new Exception("Размер страницы должен быть не меньше 1!");

        return _personRepository.GetPersonsByPage(page, size);
    }



    public Person GetUserById(int id) {
        return _personRepository.GetUserById(id);
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

    public boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) throws Exception {
        if (name == null || name.isEmpty()) throw new Exception("Имя указано некорректно!");
        if (surname == null || surname.isEmpty()) throw new Exception("Фамилия указана некорректно!");
        if (patronymic == null || patronymic.isEmpty()) throw new Exception("Отчество указано некорректно!");
        if (passportValue == null || passportValue.isEmpty()) throw new Exception("Паспортные данные указаны некорректно!"); //добавить регулярные выражения
        return _personRepository.CheckValidPassportByName(name, surname, patronymic, passportValue);
    }


}
