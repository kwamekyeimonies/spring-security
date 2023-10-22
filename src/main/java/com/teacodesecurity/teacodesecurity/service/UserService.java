package com.teacodesecurity.teacodesecurity.service;

import com.teacodesecurity.teacodesecurity.model.Role;
import com.teacodesecurity.teacodesecurity.model.UserModel;
import com.teacodesecurity.teacodesecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        System.out.println("User in the user details service "+username);
//        if(!username.equals("Daniel")) throw new UsernameNotFoundException("Invalid/Unauthorized user");
//
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(UUID.randomUUID(),"USER"));


//        return new UserModel(UUID.randomUUID(),"Daniel","Tenkorang", passwordEncoder.encode("password"),roles);

        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user is not valid"));


    }
}
