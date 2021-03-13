package api.entity;

import api.model.Address;
import api.model.Organization;
import api.model.User;

import javax.persistence.*;

@Entity
@Table(name = "REGISTRATION")
public class RegistrationEO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private User user;

    @Embedded
    private Organization organization;

    @Embedded
    private Address address;

    //todo path of logo and registrationStatus, SubPlan

    // todo convert to Date
    private String timestamp;

    public RegistrationEO() {
    }

    public RegistrationEO(User user, Organization organization, Address address, String timestamp) {
        this.user = user;
        this.organization = organization;
        this.address = address;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Address getAddress() {
        return address;
    }

    public String getTimestamp() {
        return timestamp;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
