package ru.javabegin.i_sys.web.controllers.persons;


import org.springframework.web.bind.annotation.*;
import ru.javabegin.i_sys.core.domains.persons.services.IPersonService;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoGet;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

import java.util.ArrayList;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final IPersonService _personService;

    public PersonController(IPersonService personService) {
        _personService = personService;
    }


    @GetMapping("/GetAllPersons")
    public ArrayList<PersonDtoGet> GetPersonsByPage(int id, int page) {
        return null;/////////////////
    }


    @GetMapping({"id"})
    public PersonDtoGet GetUserById(int id) {
        return null;////////////////////////////
    }


    @PostMapping("/Add")
    public void CreatePerson(@RequestBody PersonDtoPostOrPut person) {
        _personService.CreatePerson(person);
    }


    @PutMapping({"id"})
    public void UpdatePerson(int id, @RequestBody PersonDtoPostOrPut person) {
        _personService.UpdatePerson(id, person);
    }


    @DeleteMapping({"id"})
    public void DeletePerson(int id) {
        _personService.DeletePerson(id);
    }


    @GetMapping
    public boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) {
        return _personService.CheckValidPassportByName(name, surname, patronymic, passportValue);
    }




}
