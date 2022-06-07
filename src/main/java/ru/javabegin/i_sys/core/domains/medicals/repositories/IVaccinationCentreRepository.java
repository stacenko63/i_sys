package ru.javabegin.i_sys.core.domains.medicals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.medicals.VaccinationCenterDBModel;

@Repository
public interface IVaccinationCentreRepository extends JpaRepository<VaccinationCenterDBModel, Long> {
    VaccinationCenterDBModel findByName(String name);
}
