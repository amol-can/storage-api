package api.service;

import api.entity.RegistrationEO;
import api.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    public void registerUser(RegistrationEO registration){
        registrationRepository.save(registration);
    }

    public List<RegistrationEO> getRegistrations(){
        return registrationRepository.findAll();
    }

}
