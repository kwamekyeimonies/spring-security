package org.javadevelopment.service;

import lombok.RequiredArgsConstructor;
import org.javadevelopment.config.JwtService;
import org.javadevelopment.dto.AuthenticationResponse;
import org.javadevelopment.dto.RegisterRequest;
import org.javadevelopment.models.User;
import org.javadevelopment.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TwoMFAService twoMFAService;

    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .id(UUID.randomUUID())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .mfaEnabled(request.isMfaEnabled())
                .build();

        if(request.isMfaEnabled()){
            user.setSecret(twoMFAService.generateNewSecret());
        }

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .secretImageUri(twoMFAService.generateQrCodeImageUri(user.getSecret()))
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .mfaEnabled(user.isMfaEnabled())
                .build();
    }
}
