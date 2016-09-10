package com.aoide.global._01_GlobalService;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class SetUrlCollectionListener implements ServletContextListener {


    public SetUrlCollectionListener() {

    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
    
    }


    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext context = event.getServletContext();
    	Map glabalUrls = new HashMap();
    	Map memberUrls = new HashMap();
    	Map managerUrls = new HashMap();
    	
    	
    	
    	
    	
    	context.setAttribute("testContext", "from context");
    }
	
}
