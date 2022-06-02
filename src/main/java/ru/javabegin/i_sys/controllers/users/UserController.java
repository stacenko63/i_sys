package ru.javabegin.i_sys.controllers.users;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {




    @GetMapping
    public int Get() {
        return 4;
    }


}
