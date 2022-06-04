package ru.javabegin.i_sys.core.domains.persons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.persons.PersonDBModel;

@Repository

public interface IPersonRepository extends JpaRepository<PersonDBModel, Long> {
    //List<PersonDBModel> findByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);
}
