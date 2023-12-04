package org.javadevelopment.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.javadevelopment.dto.AuthenticationRequest;
import org.javadevelopment.dto.AuthenticationResponse;
import org.javadevelopment.dto.RegisterRequest;
import org.javadevelopment.dto.VerificationRequest;
import org.javadevelopment.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping(path = "/resgister")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        var response = authenticationService.register(request);
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
