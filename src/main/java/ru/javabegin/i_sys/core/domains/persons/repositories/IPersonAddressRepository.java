package ru.javabegin.i_sys.core.domains.persons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.persons.PersonAddressDBModel;

import java.util.ArrayList;

@Repository
public interface IPersonAddressRepository extends JpaRepository<PersonAddressDBModel, Long> {
    ArrayList<PersonAddressDBModel> findAllByPersonId(Long personId);
}
