package com.amit.events.sync.user.listener;

import com.amit.events.sync.user.type.EmailEvent;
import com.amit.events.sync.user.type.SMSEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @EventListener(value = {EmailEvent.class, SMSEvent.class})
    public void onNotification(Object event) {
        System.out.println(Thread.currentThread().getName() + ":Notify User - " + event);
    }
}
