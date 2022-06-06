package ru.javabegin.i_sys.data.medicals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "vaccinations")
public class VaccinationDBModel {

    /*@Id
    private Long id;

    @Column(name = "vaccination_date")
    private Date vaccinationDate;

    @Column(name = "patient_name")
    private String Name;

    @Column(name = "passport")
    private String passport;

    @Column(name = "vaccine_name")
    private String vaccineName;

    @Column(name = "vaccination_point")
    private String vaccinationPoint;*/


    @Id
    private Long id;

    @Column(name = "vaccination_date")
    private Date vaccinationDate;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "passport")
    private Long passportId;

    @Column(name = "vaccine_id")
    private Long vaccineId;

    @Column(name = "vaccination_point_id")
    private Long vaccinationPointId;

}
