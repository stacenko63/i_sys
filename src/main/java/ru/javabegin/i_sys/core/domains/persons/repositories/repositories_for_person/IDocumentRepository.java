package ru.javabegin.i_sys.core.domains.persons.repositories.repositories_for_person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.i_sys.data.persons.DocumentDBModel;

import java.util.ArrayList;

@Repository
public interface IDocumentRepository extends JpaRepository<DocumentDBModel, Long> {
    DocumentDBModel findByDocumentTypeAndValue(String documentType, String passportValue);
    ArrayList<DocumentDBModel> findAllByPersonId(Long personId);
}
