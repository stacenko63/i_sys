package ru.javabegin.i_sys.core.domains.persons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.persons.ContactDBModel;

import java.util.ArrayList;

@Repository
public interface IContactRepository extends JpaRepository<ContactDBModel, Long> {
    ArrayList<ContactDBModel> findAllByPersonId(Long personId);
}
