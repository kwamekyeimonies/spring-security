package com.teacodesecurity.teacodesecurity.service;


import com.teacodesecurity.teacodesecurity.model.Role;
import com.teacodesecurity.teacodesecurity.model.UserModel;
import com.teacodesecurity.teacodesecurity.repository.RoleRespitory;
import com.teacodesecurity.teacodesecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AuthenticationService {

    private UserRepository userRepository;

    private RoleRespitory roleRespitory;

    private PasswordEncoder passwordEncoder;

    public UserModel registerUser(String username,String fullName,String email,String password){
        System.out.println("Username: "+username);
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole =  roleRespitory.findByAuthority("USER").get();

        Set<Role> authorities= new HashSet<>();
        authorities.add(userRole);


        return userRepository.save(new UserModel(UUID.randomUUID(),fullName,username,email,encodedPassword,authorities));
    }

}
