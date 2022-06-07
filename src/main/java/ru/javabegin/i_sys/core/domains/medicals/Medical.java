package ru.javabegin.i_sys.core.domains.medicals;

import java.util.Date;

public class Medical {

    public Medical (Long Id, String Name, String Surname, String Patronymic, String PassportValue, Date VaccinationDate,
                    String VaccineName, String VaccinePointName)
    {
        this.Id = Id;
        this.Name = Name;
        this.Surname = Surname;
        this.Patronymic = Patronymic;
        this.PassportValue = PassportValue;
        this.VaccinationDate = VaccinationDate;
        this.VaccineName = VaccineName;
        this.VaccinePointName = VaccinePointName;
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
