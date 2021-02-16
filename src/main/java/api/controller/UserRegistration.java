package api.controller;

import api.repository.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/registration")
public class UserRegistration {
    @Autowired
    Registration registration;


}
