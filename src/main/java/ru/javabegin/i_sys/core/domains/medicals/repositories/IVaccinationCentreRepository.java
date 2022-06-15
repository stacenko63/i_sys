package ru.javabegin.i_sys.core.domains.medicals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.medicals.VaccinationCentreDBModel;

@Repository
public interface IVaccinationCentreRepository extends JpaRepository<VaccinationCentreDBModel, Long> {
    VaccinationCentreDBModel findByName(String name);
}
