package api.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class AddressEO {
    @Id
    @SequenceGenerator(name = "adr_seq", sequenceName = "adr_seq")
    @GeneratedValue(generator = "adr_seq")
    private Long addressId;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private Integer zipCode;
}
