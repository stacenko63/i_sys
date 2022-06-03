package ru.javabegin.i_sys.core.domains.persons.services;

import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.persons.Person;
import ru.javabegin.i_sys.core.domains.persons.repositories.IPersonRepository;

import java.util.ArrayList;

@Service
public class PersonService implements IPersonService {


    private final IPersonRepository _personRepository;

    public PersonService(IPersonRepository personRepository) {
        _personRepository = personRepository;
    }


    public ArrayList<Person> GetPersonsByPage(int page, int size) throws Exception {
        if (page < 1)
        {
            throw new Exception("Номер страницы должен быть не меньше 1!");
        }
        if (size < 1)
        {
            throw new Exception("Размер страницы должен быть не меньше 1!");
        }

        return _personRepository.GetPersonsByPage(page, size);
    }



    public Person GetUserById(int id) {
        return _personRepository.GetUserById(id);
    }



    public void CreatePerson(Person person) {
///////////////
    }



    public void UpdatePerson(int id, Person person) {
        var entity = _personRepository.GetUserById(id);
        _personRepository.UpdatePerson(id, person);
    }


    public void DeletePerson(int id) {
        _personRepository.DeletePerson(id);
    }

    public boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) throws Exception {
        if (name == null || name.isEmpty())
        {
            throw new Exception("Имя указано некорректно!");
        }
        if (surname == null || surname.isEmpty())
        {
            throw new Exception("Фамилия указана некорректно!");
        }
        if (patronymic == null || patronymic.isEmpty())
        {
            throw new Exception("Отчество указано некорректно!");
        }
        if (passportValue == null || passportValue.isEmpty() || !passportValue.matches("[0-9]{4}\\s{1}[0-9]{6}"))
        {
            throw new Exception("Паспортные данные указаны некорректно!");
        }
        return _personRepository.CheckValidPassportByName(name, surname, patronymic, passportValue);
    }


}
