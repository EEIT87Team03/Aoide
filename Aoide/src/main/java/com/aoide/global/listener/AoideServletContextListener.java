package com.aoide.global.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.aoide.global.dataBaseManipulationObjects.DataSourceProxy;
import com.aoide.global.dataBaseManipulationObjects.Playlist;
import com.aoide.global.dataBaseManipulationObjects.ad.AdService;
import com.aoide.global.dataBaseManipulationObjects.bullet.BulletDAO;
import com.aoide.global.dataBaseManipulationObjects.bullet.JdbcBulletDAO;

@WebListener
public class AoideServletContextListener implements ServletContextListener, ServletContextAttributeListener 
{

    public AoideServletContextListener() 
    {
        
    }

    @Override
    public void contextInitialized( ServletContextEvent event )  
	{ 
         ServletContext context = event.getServletContext(); 
         
         String lookupName = context.getInitParameter( "LookUp_Name" );
         DataSourceProxy.setJndiLookUpName( lookupName );
         
         context.setAttribute( Playlist.class.getName(), new Playlist() );
         //初始化
         AdService adService = new AdService();
         context.setAttribute("ads",adService.getAllAdVO());
         
         System.out.println( "Context Initialized...");
    }
	
  
    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }
}
