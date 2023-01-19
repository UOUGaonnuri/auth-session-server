package com.gaounuri.authsessionserver.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class SessionListener implements HttpSessionListener {
    private final Integer sessionTimeout = 60 * 60 * 60;
    @Override
    public void sessionCreated(HttpSessionEvent event){
        event.getSession().setMaxInactiveInterval(sessionTimeout);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {}

}
