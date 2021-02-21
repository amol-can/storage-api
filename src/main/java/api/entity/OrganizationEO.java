package api.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORGANIZATION")
public class OrganizationEO {
    /*
    @SequenceGenerator(name = "org_seq", sequenceName = "org_seq")
    @GeneratedValue(generator = "org_seq")*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orgId;
    private String companyName;
    private String businessType;
    private String companyEIN;
    private String logoUrl;
    private AddressEO address;
}
