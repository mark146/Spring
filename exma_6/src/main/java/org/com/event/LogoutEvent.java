package org.com.event;

public class LogoutEvent extends AuthenticationEvent
{
    public LogoutEvent(String username)
    {
        super(username);
    }
}
