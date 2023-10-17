package com.teacodesecurity.teacodesecurity.service;

import com.teacodesecurity.teacodesecurity.entity.User;
import com.teacodesecurity.teacodesecurity.entity.VerificationToken;
import com.teacodesecurity.teacodesecurity.model.UserModel;
import com.teacodesecurity.teacodesecurity.repository.UserRepository;
import com.teacodesecurity.teacodesecurity.repository.VerificationTokenRespository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserServiceImpl implements  UserService{

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private VerificationTokenRespository verificationTokenRespository;
    @Override
    public User registerUser(UserModel userModel){
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);

        return user;
    }

    @Override
    public void saveUserVerificationToken(String token, User user){
        VerificationToken verificationToken = new VerificationToken(user,token);
        verificationTokenRespository.save(verificationToken);
    }
}
