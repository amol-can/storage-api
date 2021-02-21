package api.entity;

import javax.persistence.*;

@Entity
@Table(name = "REGISTRATION")
public class RegistrationEO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String status;
    // TODO extract composition (has-a-relationship)
    private OrganizationEO organizations;
    // todo convert to Date
    private String timestamp;


}
