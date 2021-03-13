package api.entity;

import api.model.Address;
import api.model.Organization;
import api.model.User;

import javax.persistence.*;

@Entity
@Table(name = "USER_TBL")
public class UserEO {
    // todo Enum for userType(Role)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Embedded
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orgIdRef", referencedColumnName = "orgId")
    private OrgEO orgEO;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressIdRef", referencedColumnName = "addressId")*/
    @Embedded
    private Address address;


    public UserEO() {

    }

    public UserEO(User user, Address address, OrgEO orgEO) {
        this.user = user;
        this.address = address;
        this.orgEO = orgEO;
    }

    public Long getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrgEO getOrgEO() {
        return orgEO;
    }

    public void setOrgEO(OrgEO orgEO) {
        this.orgEO = orgEO;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
