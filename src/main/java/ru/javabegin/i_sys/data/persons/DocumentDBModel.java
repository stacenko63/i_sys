package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class DocumentDBModel {
    @Id
    private Long id;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "value")
    private String value;

    @Column(name = "person_id")
    private Long personId;

    public DocumentDBModel(Long Id, String DocumentType, String Value, Long PersonId) {
        id = Id;
        documentType = DocumentType;
        value = Value;
        personId = PersonId;
    }


    public DocumentDBModel() {

    }


    public Long GetId() {
        return id;
    }

    public String GetDocumentType() {
        return documentType;
    }

    public String GetValue() {
        return value;
    }


}
