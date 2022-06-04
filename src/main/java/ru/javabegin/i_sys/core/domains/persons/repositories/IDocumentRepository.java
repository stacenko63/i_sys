package ru.javabegin.i_sys.core.domains.persons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.persons.DocumentDBModel;

@Repository
public interface IDocumentRepository extends JpaRepository<DocumentDBModel, Long> {
    //DocumentDBModel findByDocumentTypeAndValue(String document_type, String passport_value);
    //List<DocumentDBModel> findByPersonId(Long person_id);
}
