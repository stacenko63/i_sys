package ru.javabegin.i_sys.web.controllers.medicals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javabegin.i_sys.core.domains.medicals.services.IMedicalApiService;
import ru.javabegin.i_sys.web.controllers.medicals.dto.MedicalDtoGet;

@RestController
@RequestMapping("/medical")
public class MedicalController {

    private final IMedicalApiService _medicalApiService;

    public MedicalController(IMedicalApiService medicalApiService) {
        _medicalApiService = medicalApiService;
    }

    @PostMapping("/Add")
    public void AddFile() {

    }

    @GetMapping("/passport")
    public MedicalDtoGet GetVaccineInfoByPassport(String passport) {
        return null;
    }
}
