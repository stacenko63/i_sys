package ru.javabegin.i_sys.core.domains.persons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.persons.Person;
import ru.javabegin.i_sys.core.domains.persons.repositories.*;
import ru.javabegin.i_sys.data.persons.*;

import java.util.ArrayList;

@Service
public class PersonService implements IPersonService {




    private final IPersonRepository _personRepository;

    private final IAddressRepository _addressRepository;

    private final IContactRepository _contactRepository;

    private final IDocumentRepository _documentRepository;

    private final IPersonAddressRepository _personAddressRepository;


    @Autowired
    public PersonService(IPersonRepository personRepository, IAddressRepository addressRepository,
                         IContactRepository contactRepository, IDocumentRepository documentRepository, IPersonAddressRepository personAddressRepository) {
        _personRepository = personRepository;
        _addressRepository = addressRepository;
        _contactRepository = contactRepository;
        _documentRepository = documentRepository;
        _personAddressRepository = personAddressRepository;
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
        return null;
        //return _personRepository.GetPersonsByPage(page, size);

    }



    public Person GetPersonById(Long id) throws Exception {
/*        var result = _personRepository.findById(id).orElse(null);
        if (result == null)
        {
            throw new Exception("Пользователь с указанным id не найден в системе!");
        }*/


        return null;





    }


    private void PersonValidate(Person person) {
        //валидация, которая может быть добавлена при необходимости
    }


    public void CreatePerson(Person person) {
        PersonValidate(person);

       _personRepository.save(new PersonDBModel(person.Id, person.Name, person.Surname, person.Patronymic));
        for (var el: person.Contacts)
        {
            _contactRepository.save(new ContactDBModel(el.ContactType, el.Contact, person.Id));
        }

        for (var el: person.Documents)
        {
            _documentRepository.save(new DocumentDBModel(el.DocumentType, el.Value, person.Id));
        }


        for (var el: person.Addresses)
        {
            _addressRepository.save(new AddressDBModel(el.Id, el.City, el.Street, el.StreetNumber, el.MailIndex));
            _personAddressRepository.save(new PersonAddressDBModel(el.Id,el.AddressType, person.Id));
        }
    }



    public void UpdatePerson(Long id, Person person) throws Exception {
        PersonValidate(person);
 /*       PersonDBModel result = _personRepository.findById(id).orElse(null);

        if (result == null)
        {
            throw new Exception("Пользователь с указанным id не найден в системе!");
        }*/


        ///////////////////
    }





    public void DeletePerson(Long id) throws Exception {
/*        var result = _personRepository.findById(id).orElse(null);
        if (result == null)
        {
            throw new Exception("Пользователь с указанным id не найден в системе!");
        }
        _personRepository.delete(result);


        var personsAddressesResult = _personAddressRepository.findByPersonId(id);
        if (personsAddressesResult != null)
        {
            for (var el : personsAddressesResult)
            {
                _personAddressRepository.delete(el);
            }
        }

        var documentsResult = _documentRepository.findByPersonId(id);
        if (documentsResult != null)
        {
            for (var el : documentsResult)
            {
                _documentRepository.delete(el);
            }
        }

        var contactsResult = _contactRepository.findByPersonId(id);
        if (contactsResult != null)
        {
            for (var el : contactsResult)
            {
                _contactRepository.delete(el);
            }
        }


        var addressesResult = _addressRepository.findByPersonId(id);
        if (addressesResult != null)
        {
            for (var el: addressesResult)
            {
                _addressRepository.delete(el);
            }
        }*/

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


/*        List<PersonDBModel> persons = _personRepository.findByNameAndSurnameAndPatronymic(name, surname, patronymic);
        if (persons == null)
        {
            return false;
        }

        DocumentDBModel document = _documentRepository.findByDocumentTypeAndValue("passport", passportValue);
        if (document == null)
        {
            return false;
        }

        for (var el: persons)
        {
            if (el.GetId() == document.GetId()) return true;
        }*/

        return false;
    }


}
