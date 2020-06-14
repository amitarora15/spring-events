package com.amit.events.sync.user.type;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OfferEvent {

    private String name;

    private String offer;

    private Boolean isSuccess;

}
