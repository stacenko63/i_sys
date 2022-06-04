package ru.javabegin.i_sys.core.domains.persons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.persons.AddressDBModel;

@Repository
public interface IAddressRepository extends JpaRepository<AddressDBModel, Long> {
    //List<AddressDBModel> findByPersonId(Long person_id);
}
