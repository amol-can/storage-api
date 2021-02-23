package api.controller;

import api.entity.AuthRequest;
import api.model.AuthenticationResponse;
import api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController()
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(value = "/welcome")
    public ResponseEntity<?> welcome() {
        return ResponseEntity.ok("Welcome to Storage App !!");
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(authRequest.getUserName())));
    }
}
