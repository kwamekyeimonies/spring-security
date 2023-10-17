package com.teacodesecurity.teacodesecurity.service;

import com.teacodesecurity.teacodesecurity.entity.User;
import com.teacodesecurity.teacodesecurity.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveUserVerificationToken(String token, User user);
}
