package api.controller;

import api.entity.RegistrationEO;
import api.repository.RegistrationRepository;
import api.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;


    @GetMapping
    public List<RegistrationEO> getRegistrations(){
        return registrationService.getRegistrations();
    }

    //todo send back the id of the reg user
    @PostMapping
    public void registerUser(@RequestBody RegistrationEO registration){
        registrationService.registerUser(registration);
    }

    @PostMapping(path = "/connect/{id}")
    public void connectUser(@PathVariable Long id){
        registrationService.completeRegistration(id,true);
    }

}
