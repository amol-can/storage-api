package api.service;

import api.entity.OrgEO;
import api.entity.RegistrationEO;
import api.entity.UserEO;
import api.model.Address;
import api.model.Organization;
import api.model.User;
import api.repository.OrgRepo;
import api.repository.RegistrationRepository;
import api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    UserService userService;

    @Autowired
    OrgService orgService;

    // TODO return regId
    public void registerUser(RegistrationEO registration){
        registrationRepository.save(registration);
    }

    public List<RegistrationEO> getRegistrations(){
        return registrationRepository.findAll();
    }

    //TODO write new service API to get registration by email (regStatus = false)

    public boolean completeRegistration(Long regId, boolean isItFreeTrial){
        // add plan in case of payment
        Optional<RegistrationEO> registrationEO = registrationRepository.findById(regId);
        if (registrationEO.isPresent()){
            return createUserRelatedInfra(registrationEO.get());
        }
        return false;
    }

    private boolean createUserRelatedInfra(RegistrationEO registrationEO){
        // create records in table, Table: User, Org, Subscription,
        User user = registrationEO.getUser();
        Organization organization = registrationEO.getOrganization();
        Address address = registrationEO.getAddress();
        OrgEO orgEO = new OrgEO(organization);
        UserEO userEO = new UserEO(user,address, orgEO);
        userService.addUser(userEO);


        //orgService.addOrganization(orgEO);

        // TODO Subscription plan

        // call step function
        return false;
    }

}
