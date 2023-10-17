package com.teacodesecurity.teacodesecurity.event;

import com.teacodesecurity.teacodesecurity.entity.User;
import lombok.*;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private User user;
    private String applicationUrl;
    public RegistrationCompleteEvent(User user,String applicationUrl){
       super(user);
       this.user = user;
       this.applicationUrl = applicationUrl;
    }
}
