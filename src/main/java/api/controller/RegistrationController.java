package api.controller;

import api.entity.RegistrationEO;
import api.repository.RegistrationRepository;
import api.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody RegistrationEO registration){
        Long registrationId = registrationService.registerUser(registration);
        if (registrationId == null){
            // TODO return custom exception  //return ResponseEntity;
        }
        return new ResponseEntity<>("{registrationId: "+ registrationId+"}",HttpStatus.CREATED);
    }

    // TODO move to query instead of path variable
    @GetMapping(path = "{emailId}")
    public ResponseEntity<RegistrationEO> getRegistrationByEmail(@PathVariable String emailId){
        RegistrationEO registrationEO = registrationService.getRegistrationByEmail(emailId);
        if (registrationEO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(registrationEO,HttpStatus.OK);
    }

    @PostMapping(path = "/connect/{id}")
    public void connectUser(@PathVariable Long id){
        registrationService.completeRegistration(id,true);
    }

}
