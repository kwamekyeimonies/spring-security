package com.teacodesecurity.teacodesecurity.controller;

import com.teacodesecurity.teacodesecurity.entity.User;
import com.teacodesecurity.teacodesecurity.event.RegistrationCompleteEvent;
import com.teacodesecurity.teacodesecurity.model.UserModel;
import com.teacodesecurity.teacodesecurity.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/api/v1/user")
public class RegistrationController {

    private UserService userService;
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return "Success";
    }

    private String applicationUrl(HttpServletRequest request){
        return "http://"+request.getServerName()+request.getServerPort()+ request.getContextPath();
    }

}
