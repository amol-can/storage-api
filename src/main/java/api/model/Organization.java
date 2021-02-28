package api.model;

import javax.persistence.*;

// TODO move to model class and remove Id
@Embeddable
public class Organization {
    private long orgId;
    private String companyName;
    private String businessType;
    private String companyEIN;
    private String logoUrl;
    //private AddressEO address;


    public Organization() {
    }

    public Organization(long orgId, String companyName, String businessType, String companyEIN, String logoUrl) {
        this.orgId = orgId;
        this.companyName = companyName;
        this.businessType = businessType;
        this.companyEIN = companyEIN;
        this.logoUrl = logoUrl;
    }

    public long getOrgId() {
        return orgId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getCompanyEIN() {
        return companyEIN;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public void setCompanyEIN(String companyEIN) {
        this.companyEIN = companyEIN;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "OrganizationEO{" +
                "orgId=" + orgId +
                ", companyName='" + companyName + '\'' +
                ", businessType='" + businessType + '\'' +
                ", companyEIN='" + companyEIN + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }
}