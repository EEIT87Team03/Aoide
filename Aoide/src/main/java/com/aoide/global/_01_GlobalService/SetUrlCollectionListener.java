package com.aoide.global._01_GlobalService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
    	// set path.properties in context
    	Properties props = null;
		try {
			props = new Properties();
			props.load( context.getResourceAsStream("/WEB-INF/path.properties") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		context.setAttribute("paths", props);
		
    }
	
}
