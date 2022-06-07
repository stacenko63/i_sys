package ru.javabegin.i_sys.core.domains.medicals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.medicals.VaccinationDBModel;

@Repository
public interface IVaccinationRepository extends JpaRepository<VaccinationDBModel, Long> {
    VaccinationDBModel findByPassport(String passport);
}
