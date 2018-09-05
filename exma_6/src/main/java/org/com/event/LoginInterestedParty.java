package org.com.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class LoginInterestedParty implements ApplicationListener<LoginEvent>
{
	private static final Logger logger = LoggerFactory.getLogger(LoginInterestedParty.class);

    @Override
    public void onApplicationEvent(LoginEvent event)
    {//로그인 메시지만 구독
    	logger.info("Login event for IP address {}.", event.getSource());
    }
}
