package api.entity;

import api.model.Organization;

import javax.persistence.*;

@Entity
@Table(name = "ORGANIZATION")
public class OrgEO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orgId;
    @Embedded
    private Organization organization;

    public OrgEO(){

    }

    public OrgEO(Organization organization) {
        this.organization = organization;
    }

    public Long getOrgId() {
        return orgId;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
