package com.amit.events.sync.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userServiceUnderTest;

    @Test
    public void testSuccessSignUp_notifyUser_offerSent(){
        userServiceUnderTest.userSignUp("Amit", true);
    }

    @Test
    public void testFailedSignUp_notifyUserOnly(){
        userServiceUnderTest.userSignUp("Amit", false);
    }

}

