package org.com.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationInterestedParty
        implements ApplicationListener<AuthenticationEvent>
{
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterestedParty.class);

    @Override
    public void onApplicationEvent(AuthenticationEvent event)
    {
    	System.out.println(event.getSource());
    	logger.info("Authentication event for IP address {}.", event.getSource());
    }
}
