package com.teacodesecurity.teacodesecurity.controller;


import com.teacodesecurity.teacodesecurity.entity.RegistrationDto;
import com.teacodesecurity.teacodesecurity.model.UserModel;
import com.teacodesecurity.teacodesecurity.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth")
@CrossOrigin("*")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public UserModel registerUser(@RequestBody RegistrationDto registrationDto){
        return authenticationService.registerUser(registrationDto.getUsername(),registrationDto.getFullName(),registrationDto.getEmail(),registrationDto.getPassword());
    }

}
