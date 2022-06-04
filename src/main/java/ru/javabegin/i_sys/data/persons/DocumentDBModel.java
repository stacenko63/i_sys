package ru.javabegin.i_sys.data.persons;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class DocumentDBModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "document_type")
    private String DocumentType;

    @Column(name = "value")
    private String Value;

    @Column(name = "person_id")
    private Long PersonId;

    public DocumentDBModel(String DocumentType, String Value, Long PersonId) {
        this.DocumentType = DocumentType;
        this.Value = Value;
        this.PersonId = PersonId;
    }


    public DocumentDBModel() {

    }


    public Long GetId() {
        return Id;
    }


}
