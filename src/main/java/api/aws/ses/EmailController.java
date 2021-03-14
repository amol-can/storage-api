package api.aws.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/email_verify")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity sendEmailVerification(@RequestParam("email") String email) throws IOException, MessagingException {
        boolean sentEmail = emailService.sendEmailVerification(email);
        if (sentEmail)
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<List<OtpEO>> getAllOtpRecords(){
        return new ResponseEntity(emailService.getAllOtpRecords(),HttpStatus.OK);
    }

    @GetMapping(path = "/otp_verify")
    public ResponseEntity verifyOtp(@RequestBody OtpEO otpEO){
        boolean isOtpVerified = emailService.verifyOTP(otpEO.getOtp(),otpEO.getEmailId());
        if (isOtpVerified)
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
