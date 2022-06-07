package ru.javabegin.i_sys.web.controllers.medicals.dto;

import ru.javabegin.i_sys.core.domains.medicals.Medical;

import java.util.Date;

public class MedicalDtoGet {
    public MedicalDtoGet(Medical medical) {
        this.Id = medical.Id;
        this.Name = medical.Name;
        this.Surname = medical.Surname;
        this.Patronymic = medical.Patronymic;
        this.PassportValue = medical.PassportValue;
        this.VaccinationDate = medical.VaccinationDate;
        this.VaccineName = medical.VaccineName;
        this.VaccinePointName = medical.VaccinePointName;
    }

    public Long Id;


    public String Name;


    public String Surname;


    public String Patronymic;


    public String PassportValue;


    public Date VaccinationDate;


    public String VaccineName;


    public String VaccinePointName;
}
