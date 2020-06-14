package com.amit.events.sync.user.publisher;

import com.amit.events.sync.user.type.OfferEvent;
import com.amit.events.sync.user.type.SignUpStringEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignUpPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public void publishUserSignUpEvent(String name, boolean isSuccess) {
        SignUpStringEvent event = new SignUpStringEvent(name, isSuccess);
        String message;
        if (isSuccess)
            event.setMessage("Registered successfully");
        else
            event.setMessage("Registration failed");
        eventPublisher.publishEvent(event);
        System.out.println("SignUp Event Publish complete in sync way");
    }

    public void publishOfferEvent(String name, boolean isSuccess){
        OfferEvent offerEvent = new OfferEvent(name, "Offer-1", isSuccess);
        eventPublisher.publishEvent(offerEvent);
        System.out.println("Offer Event Publish complete in sync way");
    }

}
