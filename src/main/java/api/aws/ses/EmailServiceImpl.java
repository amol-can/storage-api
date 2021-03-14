package api.aws.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private OtpRepo otpRepo;

    private static SesApiWrapper sesApiWrapper = new SesApiWrapper();

    @Override
    public boolean sendEmailVerification(String emailId) throws IOException, MessagingException {
        int otp = generateRandomNumber();
        OtpEO otpEO = new OtpEO(emailId, otp);
        otpRepo.save(otpEO);

        try {
            sesApiWrapper.send(emailId, "OTP: " + otp, "");
            return true;
        } catch (MessagingException | IOException e) {
            throw e;
        }
    }

    @Override
    public List<OtpEO> getAllOtpRecords() {
        return otpRepo.findAll();
    }

    @Override
    public boolean verifyOTP(int otp, String emailId) {
        Optional<OtpEO> otpEO = otpRepo.findById(emailId);
        if (otpEO.isPresent()) {
            // TODO add timestamp verification
            if (otpEO.get().getOtp() == otp) {
                // change user email verification to active
                return true;
            }
        }
        return false;
    }

    private int generateRandomNumber() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }
}
