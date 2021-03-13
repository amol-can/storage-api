package api.service;

import api.entity.OrgEO;
import api.repository.OrgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgService {
    @Autowired
    OrgRepo orgRepo;

    public void addOrganization(OrgEO orgEO){
        orgRepo.save(orgEO);
    }

    public List<OrgEO> getAllOrg(){
        return orgRepo.findAll();
    }
}
