package ru.javabegin.i_sys.core.domains.medicals;

import com.opencsv.bean.CsvBindByPosition;

public class MedicalCsvRead {


    @CsvBindByPosition(position = 0)
    public String Id;

    @CsvBindByPosition(position = 1)
    public String Name;

    @CsvBindByPosition(position = 2)
    public String Surname;

    @CsvBindByPosition(position = 3)
    public String Patronymic;

    @CsvBindByPosition(position = 4)
    public String PassportValue;

    @CsvBindByPosition(position = 5)
    public String VaccinationDate;

    @CsvBindByPosition(position = 6)
    public String VaccineName;

    @CsvBindByPosition(position = 7)
    public String VaccinePointName;

}

