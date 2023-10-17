package com.teacodesecurity.teacodesecurity.event.listener;

import com.teacodesecurity.teacodesecurity.entity.User;
import com.teacodesecurity.teacodesecurity.event.RegistrationCompleteEvent;
import com.teacodesecurity.teacodesecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event){
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveUserVerificationToken(token,user);

//        Send Verification email to user
        String url = event.getApplicationUrl()+"verifyRegistration?token="+token;

        log.info("Click the link to verify your account: {}",url);
    }

}
