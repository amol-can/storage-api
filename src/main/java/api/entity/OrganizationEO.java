package api.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORGANIZATION")
public class OrganizationEO {
    @Id
    @SequenceGenerator(name = "org_seq", sequenceName = "org_seq")
    @GeneratedValue(generator = "org_seq")
    private Long orgId;
    private String companyName;
    private String businessType;
    private String companyEIN;
    private String logoUrl;
    //private Address addressEO;
}
