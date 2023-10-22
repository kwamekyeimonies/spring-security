package com.teacodesecurity.teacodesecurity.service;


import com.teacodesecurity.teacodesecurity.entity.LoginResponseDto;
import com.teacodesecurity.teacodesecurity.model.Role;
import com.teacodesecurity.teacodesecurity.model.UserModel;
import com.teacodesecurity.teacodesecurity.repository.RoleRespitory;
import com.teacodesecurity.teacodesecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRespitory roleRespitory;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;
    

    public UserModel registerUser(String username,String fullName,String email,String password){
        System.out.println("Username: "+username);
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole =  roleRespitory.findByAuthority("USER").get();

        Set<Role> authorities= new HashSet<>();
        authorities.add(userRole);


        return userRepository.save(new UserModel(UUID.randomUUID(),fullName,username,email,encodedPassword,authorities));
    }

    public LoginResponseDto loginUser(String username,String password){
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password)
        );

        String token = tokenService.generateJWT(auth);

        return new LoginResponseDto(userRepository.findByUsername(username).get(),token);

    }

}
