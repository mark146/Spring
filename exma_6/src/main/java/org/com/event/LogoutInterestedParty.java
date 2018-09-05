package org.com.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogoutInterestedParty implements ApplicationListener<LogoutEvent>
{
	private static final Logger logger = LoggerFactory.getLogger(LogoutInterestedParty.class);

    @Override
    @Async
    public void onApplicationEvent(LogoutEvent event)
    {//로그아웃만 구독
    	logger.info("Logout event for IP address {}.", event.getSource());

        try
        {
            Thread.sleep(5000L);
        }
        catch(InterruptedException e)
        {
        	System.out.println(e);
        }
    }
}
