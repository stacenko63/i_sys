package ru.javabegin.i_sys.core.domains.persons.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.persons.Person;
import ru.javabegin.i_sys.core.domains.persons.repositories.*;
import ru.javabegin.i_sys.data.persons.*;
import ru.javabegin.i_sys.web.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

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
            throw new ValidationException("Номер страницы должен быть не меньше 1!");
        }
        if (size < 1)
        {
            throw new ValidationException("Размер страницы должен быть не меньше 1!");
        }


        ArrayList<Person> result = new ArrayList<>();

        var personsResult = _personRepository.findAll();

        int index = page * size - size - 1;
        while (index > personsResult.size())
        {
            index -= size;
        }
        if (personsResult.size() - size < index)
        {
            index = personsResult.size() - size;
        }
        if (index < 0)
        {
            index = 0;
        }


        for (var el: personsResult)
        {
            result.add(GetPersonById(el.GetId()));
            if (index == page * size)
            {
                break;
            }
            index++;
        }



        return result;
    }



    public Person GetPersonById(Long id) throws Exception {
        var personsResult = _personRepository.findById(id).orElse(null);
        if (personsResult == null)
        {
            throw new ValidationException("Пользователь с указанным id не найден в системе!");
        }

        var contactsResult = _contactRepository.findAllByPersonId(id);
        ArrayList<Person.Contacts> contactsCoreResult = new ArrayList<>();
        for (var el: contactsResult)
        {
            contactsCoreResult.add(new Person.Contacts(el.GetId(), el.GetContactType(), el.GetContact()));
        }



        var documentsResult = _documentRepository.findAllByPersonId(id);
        ArrayList<Person.Documents> documentsCoreResult = new ArrayList<>();
        for (var el: documentsResult)
        {
            documentsCoreResult.add(new Person.Documents(el.GetId(), el.GetDocumentType(), el.GetValue()));
        }



        ArrayList<Person.Addresses> addressesResult = new ArrayList<>();
        var personsAddressesResult = _personAddressRepository.findAllByPersonId(id);

        for (var el: personsAddressesResult)
        {
            var entity = _addressRepository.findById(el.GetId()).orElse(null);
            addressesResult.add(new Person.Addresses(el.GetId(), el.GetAddressType(), entity.GetCity(), 
                    entity.GetStreet(), entity.GetStreetNumber(), entity.GetMailIndex()));
        }



        return new Person(id, personsResult.GetName(), personsResult.GetSurname(),
                personsResult.GetPatronymic(), documentsCoreResult, addressesResult, contactsCoreResult);
    }


    private void PersonValidate(Person person) {
        //валидация, которая может быть добавлена при необходимости
    }


    public void CreatePerson(Person person) {
        PersonValidate(person);

       _personRepository.save(new PersonDBModel(person.Id, person.Name, person.Surname, person.Patronymic));
        for (var el: person.Contacts)
        {
            _contactRepository.save(new ContactDBModel(el.Id, el.ContactType, el.Contact, person.Id));
        }

        for (var el: person.Documents)
        {
            _documentRepository.save(new DocumentDBModel(el.Id, el.DocumentType, el.Value, person.Id));
        }


        for (var el: person.Addresses)
        {
            _addressRepository.save(new AddressDBModel(el.Id, el.City, el.Street, el.StreetNumber, el.MailIndex));
            _personAddressRepository.save(new PersonAddressDBModel(el.Id,el.AddressType, person.Id));
        }
    }



    public void UpdatePerson(Long id, Person person) throws Exception {
        PersonValidate(person);
        PersonDBModel result = _personRepository.findById(id).orElse(null);

        if (result == null)
        {
            throw new ValidationException("Пользователь с указанным id не найден в системе!");
        }

        DeletePerson(id);
        person.Id = id;
        CreatePerson(person);

    }





    public void DeletePerson(Long id) throws Exception {
        var result = _personRepository.findById(id).orElse(null);
        if (result == null)
        {
            throw new ValidationException("Пользователь с указанным id не найден в системе!");
        }
        _personRepository.delete(result);


        var personsAddressesResult = _personAddressRepository.findAllByPersonId(id);
        if (personsAddressesResult != null)
        {
            for (var el : personsAddressesResult)
            {
                _personAddressRepository.delete(el);
            }
        }

        var documentsResult = _documentRepository.findAllByPersonId(id);
        if (documentsResult != null)
        {
            for (var el : documentsResult)
            {
                _documentRepository.delete(el);
            }
        }

        var contactsResult = _contactRepository.findAllByPersonId(id);
        if (contactsResult != null)
        {
            for (var el : contactsResult)
            {
                _contactRepository.delete(el);
            }
        }

    }




    public boolean CheckValidPassportByName(String name, String surname, String patronymic, String passportValue) throws Exception {
        if (name == null || name.isEmpty())
        {
            throw new ValidationException("Имя указано некорректно!");
        }
        if (surname == null || surname.isEmpty())
        {
            throw new ValidationException("Фамилия указана некорректно!");
        }
        if (patronymic == null || patronymic.isEmpty())
        {
            throw new ValidationException("Отчество указано некорректно!");
        }
        if (passportValue == null || !passportValue.matches("[0-9]{4}\\s{1}[0-9]{6}"))
        {
            throw new ValidationException("Паспортные данные указаны некорректно!");
        }


        List<PersonDBModel> persons = _personRepository.findAllByNameAndSurnameAndPatronymic(name, surname, patronymic);
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
            if (el.GetId().equals(document.GetPersonId()))
            {
                return true;
            }
        }

        return false;
    }


}
