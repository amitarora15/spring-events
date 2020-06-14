package com.amit.events.sync.user.type;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SMSEvent {

    private String name;

    private String mobile;

    private String message;
}
