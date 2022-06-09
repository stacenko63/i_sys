package ru.javabegin.i_sys.web.controllers.persons;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.javabegin.i_sys.core.domains.persons.services.IPersonService;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoGet;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

import java.util.ArrayList;



@RestController
@RequestMapping("/person")
public class PersonController {

    private final IPersonService _personService;

    private static final Logger Log = LoggerFactory.getLogger(PersonController.class.getName());

    public PersonController(IPersonService personService) {
        _personService = personService;
    }


    @GetMapping("/GetAllPersons")
    public ArrayList<PersonDtoGet> GetPersonsByPage(int page, int size) throws Exception {
        Log.info("Call Method of PersonController: GetPersonByPage(" + page + "," + size + ")");
        var entity = _personService.GetPersonsByPage(page, size);
        var result = new ArrayList<PersonDtoGet>();
        for (var el: entity) {
            result.add(new PersonDtoGet(el));
        }
        Log.info("Method of PersonController: GetPersonByPage(" + page + "," + size + "): HttpStatus 200");
        return result;
    }


    @GetMapping({"id"})
    public PersonDtoGet GetPersonById(Long id) throws Exception{
        Log.info("Call Method of PersonController: GetPersonById(" + id + ")");
        var result = new PersonDtoGet(_personService.GetPersonById(id));
        Log.info("Method of PersonController: GetPersonById(" + id + ") HttpStatus 200");
        return result;
    }


    @PostMapping("/Add")
    public void CreatePerson(@RequestBody PersonDtoPostOrPut person) throws Exception{
        Log.info("Call Method of PersonController: CreatePerson(" + person + ")");
        _personService.CreatePerson(person.ConvertToCoreModel());
        Log.info("Call Method of PersonController: CreatePerson(" + person + ") HttpStatus 200");
    }


    @PutMapping({"id"})
    public void UpdatePerson(Long id, @RequestBody PersonDtoPostOrPut person) throws Exception{
        Log.info("Call Method of PersonController: UpdatePerson(" + id + "," + person + ")");
        _personService.UpdatePerson(id, person.ConvertToCoreModel());
        Log.info("Call Method of PersonController: UpdatePerson(" + person + ") HttpStatus 200");
    }


    @DeleteMapping({"id"})
    public void DeletePerson(Long id) throws Exception{
        Log.info("Call Method of PersonController: DeletePerson(" + id + ")");
        _personService.DeletePerson(id);
        Log.info("Method of PersonController: DeletePerson(" + id + ") HttpStatus 200");
    }


    @GetMapping
    public boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) throws Exception {
        Log.info("Call Method of PersonController: CheckValidPassportByName(" + name + "," + surname + "," +
                patronymic + "," + passportValue + ")");
        var result =  _personService.CheckValidPassportByName(name, surname, patronymic, passportValue);
        Log.info("Method of PersonController: CheckValidPassportByName(" + name + "," + surname + "," +
                patronymic + "," + passportValue + ") HttpStatus 200");
        return result;
    }




}
