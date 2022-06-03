package ru.javabegin.i_sys.data.persons.repositories;

import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.core.domains.persons.Person;
import ru.javabegin.i_sys.core.domains.persons.repositories.IPersonRepository;

import java.util.ArrayList;

@Repository
public class PersonRepository implements IPersonRepository {


    public ArrayList<Person> GetPersonsByPage(int page, int size) {
        return null;///////////////
    }


    public Person GetUserById(int id) {
        return null;////////
    }


    public void CreatePerson(Person person) {
       ////
    }


    public void UpdatePerson(int id, Person person) {
/////
    }





    public void DeletePerson(int id) {
//////////////
    }

    public boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) {
        return false;///////
    }
}
