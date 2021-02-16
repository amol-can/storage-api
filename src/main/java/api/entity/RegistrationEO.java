package api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REGISTRATION")
public class RegistrationEO {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    // TODO extract composition (has-a-relationship)
    private String companyName;
    private String businessType;
    private String companyEIN;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private int zipCode;
    private String logoUrl;


}
