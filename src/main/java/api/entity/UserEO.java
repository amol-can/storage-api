package api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TBL_TEMP")
public class UserEO {
    // todo Enum for userType(Role)
    @Id
    private Long userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String userType;
    private String createdDate;

    public UserEO(){

    }


}
