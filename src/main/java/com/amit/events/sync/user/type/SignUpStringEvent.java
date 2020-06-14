package com.amit.events.sync.user.type;

import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SignUpStringEvent extends SignUpEvent<String> {

    public SignUpStringEvent(String name, Boolean isSuccess){
        super(name, isSuccess);
    }


}
