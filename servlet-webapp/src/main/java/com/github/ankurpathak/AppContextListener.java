package com.github.ankurpathak;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;


@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Default App Initializer......");
        ServletContext context = event.getServletContext();
        try {
            var servlet = context.createServlet(DefaultAppController.class);
            var registration = context.addServlet("defaultAppController", servlet);
            registration.addMapping("/default");
            registration.setLoadOnStartup(1);
        } catch (ServletException ex) {
            ex.printStackTrace();
        }

    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}