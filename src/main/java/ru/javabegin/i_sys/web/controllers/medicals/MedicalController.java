package ru.javabegin.i_sys.web.controllers.medicals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javabegin.i_sys.core.domains.medicals.services.IMedicalApiService;
import ru.javabegin.i_sys.web.controllers.medicals.dto.MedicalDtoGet;



@RestController
@RequestMapping("/medical")
public class MedicalController {

    private static final Logger Log = LoggerFactory.getLogger(MedicalController.class.getName());
    private final IMedicalApiService _medicalApiService;

    public MedicalController(IMedicalApiService medicalApiService) {
        _medicalApiService = medicalApiService;
    }

    @PostMapping("/Add")
    public void AddFile(String filePath) throws Exception {
        Log.info("Call Method of MedicalController: AddFile(" + filePath + ")");
        _medicalApiService.AddFile(filePath);
        Log.info("Method of MedicalController: AddFile(" + filePath + ") HttpStatus 200");
    }

    @GetMapping("/passport")
    public MedicalDtoGet GetVaccineInfoByPassport(String passport) throws Exception {
        Log.info("Call Method of MedicalController: GetVaccineInfoByPassport(" + passport + ")");
        var result = new MedicalDtoGet(_medicalApiService.GetVaccineInfoByPassport(passport));
        Log.info("Method of MedicalController: GetVaccineInfoByPassport(" + passport + ") HttpStatus 200");
        return result;
    }
}
