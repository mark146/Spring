package org.com.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogoutInterestedParty implements ApplicationListener<LogoutEvent>
{
    @Override
    @Async
    public void onApplicationEvent(LogoutEvent event)
    {
    	System.out.println("Logout event for IP address {}."+event.getSource());
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
