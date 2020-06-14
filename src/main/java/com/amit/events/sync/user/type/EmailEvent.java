package com.amit.events.sync.user.type;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailEvent {

    private String name;

    private String emailAddress;

    private String message;

}
