package ru.javabegin.i_sys.web.controllers.persons;


import org.springframework.web.bind.annotation.*;
import ru.javabegin.i_sys.core.domains.persons.services.IPersonService;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoGet;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

import java.util.ArrayList;
import java.util.logging.Logger;


@RestController
@RequestMapping("/person")
public class PersonController {

    private final IPersonService _personService;

    private static final Logger Log = Logger.getLogger("person_logger");

    public PersonController(IPersonService personService) {
        _personService = personService;
    }


    @GetMapping("/GetAllPersons")
    public ArrayList<PersonDtoGet> GetPersonsByPage(int page, int size) throws Exception {
        Log.info("start GetPersonByPage");
        var entity = _personService.GetPersonsByPage(page, size);
        var result = new ArrayList<PersonDtoGet>();
        for (var el: entity) {
            result.add(new PersonDtoGet(el));
        }
        return result;
    }


    @GetMapping({"id"})
    public PersonDtoGet GetPersonById(Long id) throws Exception{
        return new PersonDtoGet(_personService.GetPersonById(id));
    }


    @PostMapping("/Add")
    public void CreatePerson(@RequestBody PersonDtoPostOrPut person) throws Exception{
        _personService.CreatePerson(person.ConvertToCoreModel());
    }


    @PutMapping({"id"})
    public void UpdatePerson(Long id, @RequestBody PersonDtoPostOrPut person) throws Exception{
        _personService.UpdatePerson(id, person.ConvertToCoreModel());
    }


    @DeleteMapping({"id"})
    public void DeletePerson(Long id) throws Exception{
        _personService.DeletePerson(id);
    }


    @GetMapping
    public boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) throws Exception {
        return _personService.CheckValidPassportByName(name, surname, patronymic, passportValue);
    }




}
