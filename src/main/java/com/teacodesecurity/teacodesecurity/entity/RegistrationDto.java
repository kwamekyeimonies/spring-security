package com.teacodesecurity.teacodesecurity.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationDto {
    private String username;
    private String email;
    private String fullName;
    private String password;


}
