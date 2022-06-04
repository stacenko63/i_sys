package ru.javabegin.i_sys.core.domains.persons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.persons.ContactDBModel;

@Repository
public interface IContactRepository extends JpaRepository<ContactDBModel, Long> {
    //List<ContactDBModel> findByPersonId(Long person_id);
}
