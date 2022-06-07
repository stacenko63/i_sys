package ru.javabegin.i_sys.data.medicals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "vaccinations")
public class VaccinationDBModel {

    public VaccinationDBModel(Long Id, Date VaccinationDate, String PatientName, String PatientSurname,
                              String PatientPatronymic, String Passport, Long VaccineId, Long PointId)
    {
        id = Id;
        vaccinationDate = VaccinationDate;
        patientName = PatientName;
        patientSurname = PatientSurname;
        patientPatronymic = PatientPatronymic;
        passport = Passport;
        vaccineId = VaccineId;
        pointId = PointId;
    }


    @Id
    private Long id;

    @Column(name = "vaccination_date")
    private Date vaccinationDate;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_surname")
    private String patientSurname;

    @Column(name = "patient_patronymic")
    private String patientPatronymic;

    @Column(name = "passport")
    private String passport;

    @Column(name = "vaccine_id")
    private Long vaccineId;

    @Column(name = "point_id")
    private Long pointId;

    public Long GetId() {
        return id;
    }

    public Date GetVaccinationDate() {
        return vaccinationDate;
    }

    public String GetPatientName() {
        return patientName;
    }

    public String GetPatientSurname() {
        return patientSurname;
    }

    public String GetPatronymic() {
        return patientPatronymic;
    }

    public String GetPatientPassport() {
        return passport;
    }

    public Long GetVaccineId() {
        return vaccineId;
    }

    public Long GetPointId() {
        return pointId;
    }






}
