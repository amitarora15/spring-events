package com.amit.events.sync.user.listener;

import com.amit.events.sync.user.type.SignUpEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDashboardListener {

    @EventListener
    public void onSignUpEvent(SignUpEvent<String> event){
        System.out.println(Thread.currentThread().getName() + ":User Dashboard Update -" + event);
    }

}
