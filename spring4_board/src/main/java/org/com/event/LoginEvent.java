package org.com.event;

public class LoginEvent extends AuthenticationEvent
{
    public LoginEvent(String username)
    {
        super(username);
        System.out.println("login = "+username);
    }
}