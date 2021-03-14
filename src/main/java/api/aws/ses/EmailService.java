package api.aws.ses;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface EmailService {
    public boolean sendEmailVerification(String emailId) throws IOException, MessagingException;
    List<OtpEO> getAllOtpRecords();
    public boolean verifyOTP(int otp, String emailId);
}
