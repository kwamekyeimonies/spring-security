package com.teacodesecurity.teacodesecurity.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
}
