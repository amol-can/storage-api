package api.service;

import api.entity.OrgEO;
import api.entity.RegistrationEO;
import api.entity.UserEO;
import api.model.Address;
import api.model.Organization;
import api.model.User;
import api.repository.RegistrationRepository;
import api.subscription.entity.Plan;
import api.subscription.entity.Subscription;
import api.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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

    @Autowired
    private SubscriptionService subscriptionService;

    public Long registerUser(RegistrationEO registration){
        registrationRepository.save(registration);
        return registration.getId();
    }

    public List<RegistrationEO> getRegistrations(){
        return registrationRepository.findAll();
    }

    //TODO get list and filter by email (regStatus = false)
    public RegistrationEO getRegistrationByEmail(String email){
        RegistrationEO registrationEO = registrationRepository.findByUserEmail(email);
        if (registrationEO == null){
            // TODO throw custom exception
        }
        return registrationEO;
    }

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

        // TODO Subscription plan
        Subscription subscription = new Subscription();
        //subscription.setPlan();
        subscription.setUserId(user.getUserId());
        subscription.setSubscriptionStartDate(new Date());
        //LocalDate.now().plusDays(15);
        Date today=new Date();
        long ltime=today.getTime()+15*24*60*60*1000;
        Date today15=new Date(ltime);
        subscription.setSubscriptionEndDate(today15);

        subscriptionService.addSubscription(subscription);

        // call step function
        return false;
    }

}
