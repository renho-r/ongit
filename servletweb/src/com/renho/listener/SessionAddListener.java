package com.renho.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionAddListener implements HttpSessionListener {

    public SessionAddListener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
         System.out.println("SessionAddListener sessionCreated");
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
