package api.service;

import api.entity.UserEO;
import api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void addUser(UserEO userEO){
        userRepo.save(userEO);
    }

    public List<UserEO> getAllUsers(){
        return userRepo.findAll();
    }



}
