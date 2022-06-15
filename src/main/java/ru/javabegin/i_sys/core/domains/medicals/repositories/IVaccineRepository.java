package ru.javabegin.i_sys.core.domains.medicals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.medicals.VaccineDBModel;

@Repository
public interface IVaccineRepository extends JpaRepository<VaccineDBModel, Long> {

    VaccineDBModel findByName(String name);
}
