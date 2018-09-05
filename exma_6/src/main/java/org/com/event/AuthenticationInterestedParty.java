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
    {//로그인이나 로그아웃 메시지에 대해 모두 호출되지만
    	logger.info("Authentication event for IP address {}.", event.getSource());
    }
}
