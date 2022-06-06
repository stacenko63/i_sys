package ru.javabegin.i_sys.core.domains.medicals.services;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.medicals.Medical;
import ru.javabegin.i_sys.core.domains.persons.services.IPersonService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class MedicalApiService implements IMedicalApiService {

    private final IPersonService _personService;

    public MedicalApiService(IPersonService personService) {
        _personService = personService;
    }

    @Override
    public void AddFile(String filePath) throws FileNotFoundException {
        List<Medical> beans = new CsvToBeanBuilder(new FileReader(filePath))
                .withType(Medical.class)
                .build()
                .parse();


    }

    @Override
    public Medical GetVaccineInfoByPassport(String passport) {
        return null;
    }
}
