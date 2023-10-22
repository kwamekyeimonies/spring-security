package com.teacodesecurity.teacodesecurity.entity;


import com.teacodesecurity.teacodesecurity.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LoginResponseDto {
    private UserModel userModel;
    private String jwt;
}
