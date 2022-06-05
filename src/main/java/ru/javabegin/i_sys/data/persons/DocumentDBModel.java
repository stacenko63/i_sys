package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class DocumentDBModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "value")
    private String value;

    @Column(name = "person_id")
    private Long personId;

    public DocumentDBModel(String DocumentType, String Value, Long PersonId) {
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
