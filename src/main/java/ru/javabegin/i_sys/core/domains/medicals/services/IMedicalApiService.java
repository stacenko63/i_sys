package ru.javabegin.i_sys.core.domains.medicals.services;

import org.springframework.stereotype.Service;
import ru.javabegin.i_sys.core.domains.medicals.Medical;

import java.io.FileNotFoundException;

@Service
public interface IMedicalApiService {


    void AddFile(String filePath) throws Exception;

    Medical GetVaccineInfoByPassport(String passport) throws Exception;
}
