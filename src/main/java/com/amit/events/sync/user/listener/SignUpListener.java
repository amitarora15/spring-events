package com.amit.events.sync.user.listener;

import com.amit.events.sync.user.type.EmailEvent;
import com.amit.events.sync.user.type.SMSEvent;
import com.amit.events.sync.user.type.SignUpEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SignUpListener {

    @EventListener
    public List<Object> onSignUpEvent(SignUpEvent<String> event){
        System.out.println(Thread.currentThread().getName() + ":Sign Up -" + event);
        // get info about user
        System.out.println(Thread.currentThread().getName() + ":" + "Listener publishing multiple events");
        EmailEvent emailEvent = EmailEvent.builder().emailAddress("amit@gmail.com").name(event.getName()).message(event.getMessage()).build();
        SMSEvent smsEvent = SMSEvent.builder().mobile("981010101010").name(event.getName()).message(event.getMessage()).build();
        List<Object> events = new ArrayList<>();
        events.add(emailEvent);
        events.add(smsEvent);
        return events;
    }

}
