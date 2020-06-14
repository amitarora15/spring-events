package com.amit.events.sync.user.service;

import com.amit.events.sync.user.publisher.SignUpPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final SignUpPublisher signUpPublisher;

    public void userSignUp(String name, boolean isSuccess){
        signUpPublisher.publishUserSignUpEvent(name, isSuccess);
        signUpPublisher.publishOfferEvent(name, isSuccess);
    }
}
