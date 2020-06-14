package com.amit.events.sync.user.listener;

import com.amit.events.sync.user.type.OfferEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OfferListener {

    @EventListener(condition = "#offerEvent.isSuccess == true")
    public void onOfferEvent(OfferEvent offerEvent){
        System.out.println(Thread.currentThread().getName() + ":Release Offer - " + offerEvent);
    }
}
