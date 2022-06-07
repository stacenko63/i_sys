package ru.javabegin.i_sys.core.domains.medicals.services;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.medicals.Medical;
import ru.javabegin.i_sys.core.domains.medicals.MedicalCsvRead;
import ru.javabegin.i_sys.core.domains.medicals.repositories.IVaccinationCentreRepository;
import ru.javabegin.i_sys.core.domains.medicals.repositories.IVaccinationRepository;
import ru.javabegin.i_sys.core.domains.medicals.repositories.IVaccineRepository;
import ru.javabegin.i_sys.core.domains.persons.services.IPersonService;
import ru.javabegin.i_sys.data.medicals.VaccinationDBModel;

import java.io.FileReader;
import java.util.List;
import java.util.Random;

@Service
public class MedicalApiService implements IMedicalApiService {

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

    @Override
    public void AddFile(String filePath) throws Exception {
        List<MedicalCsvRead> beans = new CsvToBeanBuilder(new FileReader(filePath))
                .withType(Medical.class)
                .build()
                .parse();

        for (var el: beans)
        {
            if (el.Id == null || el.Patronymic == null || el.Surname == null || el.Name == null || el.VaccineName == null ||

                    el.VaccinationDate == null || el.VaccinePointName == null)
            {
                throw new Exception("Некорректный ввод данных в файле!");
            }

            if (el.PassportValue.matches("[0-9]{4}\\s{1}[0-9]{6}"))
            {
                throw new Exception("Паспортные данные указаны некорректно!");
            }


            if (!_personService.CheckValidPassportByName(el.Name, el.Surname, el.Patronymic, el.PassportValue))
            {
                throw new Exception("Некорректная связь ФИО с паспортом!");
            }

            Long Id = el.Id.matches("'^\\d+$'") ? Long.parseLong(el.Id) : new Random().nextLong();

            var point = _vaccinationCentreRepository.findByName(el.VaccinePointName);

            if (point == null)
            {
                throw new Exception("Пункт вакцинации с указанным названием не найден в системе!");
            }

            var vaccine = _vaccineRepository.findByName(el.VaccineName);

            if (vaccine == null)
            {
                throw new Exception("Вакцина с указанным названием не найдена в системе!");
            }

            _vaccinationRepository.save(new VaccinationDBModel(Id, el.VaccinationDate, el.Name, el.Surname, el.Patronymic,
                    el.PassportValue, vaccine.GetId(), point.GetId()));
        }


    }

    @Override
    public Medical GetVaccineInfoByPassport(String passport) throws Exception {

        if (passport == null || !passport.matches("[0-9]{4}\\s{1}[0-9]{6}"))
        {
            throw new Exception("Паспортные данные указаны некорректно!");
        }

        var vaccination = _vaccinationRepository.findByPassport(passport);

        if (vaccination == null)
        {
            throw new Exception("Указанный паспорт не найден в системе!");
        }

        var vaccine = _vaccineRepository.findById(vaccination.GetVaccineId()).orElse(null);

        if (vaccine == null)
        {
            throw new Exception("Внутренняя ошибка системы!");
        }

        var point =_vaccinationCentreRepository.findById(vaccination.GetPointId()).orElse(null);

        if (point == null)
        {
            throw new Exception("Внутренняя ошибка системы!");
        }

        return new Medical(vaccination.GetId(), vaccination.GetPatientName(), vaccination.GetPatientSurname(),
                vaccination.GetPatronymic(), vaccination.GetPatientPassport(),
                vaccination.GetVaccinationDate(), vaccine.GetName(), point.GetName());
    }
}
