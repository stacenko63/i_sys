package ru.javabegin.i_sys.core.domains.medicals.services;

import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.medicals.Medical;
import ru.javabegin.i_sys.core.domains.medicals.MedicalCsvRead;
import ru.javabegin.i_sys.core.domains.medicals.repositories.IVaccinationCentreRepository;
import ru.javabegin.i_sys.core.domains.medicals.repositories.IVaccinationRepository;
import ru.javabegin.i_sys.core.domains.medicals.repositories.IVaccineRepository;
import ru.javabegin.i_sys.core.domains.persons.services.IPersonService;
import ru.javabegin.i_sys.data.medicals.VaccinationCentreDBModel;
import ru.javabegin.i_sys.data.medicals.VaccinationDBModel;
import ru.javabegin.i_sys.data.medicals.VaccineDBModel;
import ru.javabegin.i_sys.web.exceptions.ValidationException;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;


@Service
public class MedicalApiService implements IMedicalApiService {

    private static final Logger Log = LoggerFactory.getLogger(MedicalApiService.class.getName());

    private final IVaccinationCentreRepository _vaccinationCentreRepository;

    private final IVaccinationRepository _vaccinationRepository;

    private final IVaccineRepository _vaccineRepository;
    private final IPersonService _personService;

    public MedicalApiService(IVaccinationCentreRepository vaccinationCentreRepository,
                             IVaccinationRepository vaccinationRepository, IVaccineRepository vaccineRepository,
                             IPersonService personService) {
        _vaccinationCentreRepository = vaccinationCentreRepository;
        _vaccinationRepository = vaccinationRepository;
        _vaccineRepository = vaccineRepository;
        _personService = personService;
    }


    public void AddFile(String filePath) throws Exception {
        Log.info("Call Method of MedicalApiService: AddFile(" + filePath + ")");

        List<MedicalCsvRead> beans = new CsvToBeanBuilder(new FileReader(filePath))
                .withType(MedicalCsvRead.class)
                .build()
                .parse();

        for (var el: beans)
        {
            if (el.Id == null || el.Patronymic == null || el.Surname == null || el.Name == null || el.VaccineName == null ||

                    el.VaccinationDate == null || el.VaccinePointName == null)
            {
                throw new ValidationException("Incorrect data entry in the file!");
            }

            if (!el.PassportValue.matches("[0-9]{4}\\s{1}[0-9]{6}"))
            {
                throw new ValidationException("The passport is incorrect!");
            }


            if (!_personService.CheckValidPassportByName(el.Name, el.Surname, el.Patronymic, el.PassportValue))
            {
                throw new ValidationException("Incorrect connection of the full name with the passport!");
            }

            Long Id = el.Id.matches("'^\\d+$'") ? Long.parseLong(el.Id) : abs(new Random().nextLong());

            while (_vaccinationRepository.findById(Id).orElse(null) != null)
            {
                Id = abs(new Random().nextLong());
            }

            _vaccinationCentreRepository.save(new VaccinationCentreDBModel(1L, "Point1", "Address1"));
            _vaccineRepository.save(new VaccineDBModel(1L, "Sputnik"));

            var point = _vaccinationCentreRepository.findByName(el.VaccinePointName);


            if (point == null)
            {
                throw new ValidationException("The vaccination point with the specified name was not found in the system!");
            }

            var vaccine = _vaccineRepository.findByName(el.VaccineName);

            if (vaccine == null)
            {
                throw new ValidationException("The vaccine with the specified name was not found in the system!");
            }



            _vaccinationRepository.save(new VaccinationDBModel(Id, new SimpleDateFormat("yyyy-MM-dd").parse(el.VaccinationDate),
                    el.Name, el.Surname, el.Patronymic,
                    el.PassportValue, vaccine.GetId(), point.GetId()));

        }

        Log.info("Method of MedicalApiService: AddFile(" + filePath + ") successfully completed");

    }


    public Medical GetVaccineInfoByPassport(String passport) throws Exception {

        Log.info("Call Method of MedicalApiService: GetVaccineInfoByPassport(" + passport + ")");

        if (passport == null || !passport.matches("[0-9]{4}\\s{1}[0-9]{6}"))
        {
            throw new ValidationException("Passport data is incorrect!");
        }

        var vaccination = _vaccinationRepository.findByPassport(passport);

        if (vaccination == null)
        {
            throw new ValidationException("The specified passport was not found in the system!");
        }

        var vaccine = _vaccineRepository.findById(vaccination.GetVaccineId()).orElse(null);

        if (vaccine == null)
        {
            throw new Exception("The vaccine with the specified id is not in the database!");
        }

        var point =_vaccinationCentreRepository.findById(vaccination.GetPointId()).orElse(null);

        if (point == null)
        {
            throw new Exception("The vaccination point with the specified id is not in the database!");
        }

        Log.info("Method of MedicalApiService: GetVaccineInfoByPassport(" + passport + ") successfully completed");

        return new Medical(vaccination.GetId(), vaccination.GetPatientName(), vaccination.GetPatientSurname(),
                vaccination.GetPatronymic(), vaccination.GetPatientPassport(),
                vaccination.GetVaccinationDate(), vaccine.GetName(), point.GetName());
    }
}
