package ru.javabegin.i_sys.core.domains.persons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.persons.PersonDBModel;

import java.util.ArrayList;

@Repository
public interface IPersonRepository extends JpaRepository<PersonDBModel, Long> {
    ArrayList<PersonDBModel> findAllByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);



}
