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
    private boolean status;
    @Embedded
    private OrganizationEO organization;
    // todo convert to Date
    private String timestamp;

    public RegistrationEO() {
    }

    public RegistrationEO(String firstName, String lastName, String email, String phone, boolean status,
                          OrganizationEO organization, String timestamp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.organization = organization;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean getStatus() {
        return status;
    }

    public OrganizationEO getOrganization() {
        return organization;
    }

    public String getTimestamp() {
        return timestamp;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setOrganization(OrganizationEO organization) {
        this.organization = organization;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "RegistrationEO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", organization=" + organization +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
