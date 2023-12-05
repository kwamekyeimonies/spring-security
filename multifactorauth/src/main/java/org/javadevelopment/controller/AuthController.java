package org.javadevelopment.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javadevelopment.dto.AuthenticationRequest;
import org.javadevelopment.dto.AuthenticationResponse;
import org.javadevelopment.dto.RegisterRequest;
import org.javadevelopment.dto.VerificationRequest;
import org.javadevelopment.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping(path = "/resgister")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        var response = authenticationService.register(request);
        log.info("did i run {}",request.getEmail());
        if(request.isMfaEnabled()){
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.accepted().build();
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }


    @PostMapping(path = "/verfiy")
    public ResponseEntity<?> verifyCode(@RequestBody VerificationRequest verificationRequest){
        return ResponseEntity.ok(authenticationService.verifyCode(verificationRequest));
    }

    @PostMapping(path = "/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException{
        authenticationService.refreshToken(request,response);
    }

}
