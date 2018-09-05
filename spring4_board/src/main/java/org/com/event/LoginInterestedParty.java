package org.com.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LoginInterestedParty implements ApplicationListener<LoginEvent>
{

    @Override
    @Async
    public void onApplicationEvent(LoginEvent event)
    {
    	System.out.println("Login event for IP address {}. = "+event.getSource());
    }
}