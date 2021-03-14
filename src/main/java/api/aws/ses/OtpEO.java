package api.aws.ses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OTP")
public class OtpEO {
    @Id
    private String emailId;
    private int otp;
    private Date generatedTimeStamp = new Date();

    public OtpEO(){

    }

    public OtpEO(String emailId, int otp) {
        this.emailId = emailId;
        this.otp = otp;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public Date getGeneratedTimeStamp() {
        return generatedTimeStamp;
    }

    public void setGeneratedTimeStamp(Date generatedTimeStamp) {
        this.generatedTimeStamp = generatedTimeStamp;
    }
}
