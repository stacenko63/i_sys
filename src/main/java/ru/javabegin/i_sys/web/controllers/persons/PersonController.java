package ru.javabegin.i_sys.web.controllers.persons;


import org.springframework.web.bind.annotation.*;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoGet;
import ru.javabegin.i_sys.web.controllers.persons.dto.PersonDtoPostOrPut;

@RestController
@RequestMapping("/person")
public class PersonController {

    /*private final IPersonService _personService;

    public PersonController(IPersonService personService) {
        _personService = personService;
    }*/

    //получение данных о гражданах постранично
/*    @GetMapping
    public int GetPersonsByPage(int id, int page) {
        return 5;/////////////////
    }*/

    //получение данных о конкретном гражданине по id
    @GetMapping({"id"})
    public PersonDtoGet GetUserById(int id) {
        return null;
    }

    //добавление данных о гражданине
    @PostMapping("/add")
    public void CreatePerson(@RequestBody PersonDtoPostOrPut person) {

    }

    //редактирование данных о гражданине
    @PutMapping({"id"})
    public void UpdatePerson(int id, @RequestBody PersonDtoPostOrPut person) {

    }

    //удаление данных о гражданине
    @DeleteMapping({"id"})
    public void DeletePerson(int id) {

    }

    //проверка валидности связки ФИО + паспорт
    @GetMapping
    public boolean CheckValidPassportByName(String name, String surname, String patronymic) {
        return true;
    }




}
