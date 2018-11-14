package com.github.ankurpathak;

import org.apache.commons.collections4.CollectionUtils;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;
import java.util.Set;


@HandlesTypes({HttpServlet.class})
public class AppInitializer implements ServletContainerInitializer {
    public void onStartup(Set<Class<?>> types, ServletContext context) {
        System.out.println("Root App Initializer......");
        if(!CollectionUtils.isEmpty(types)){
            types.stream()
                    .filter(RootAppController.class::equals)
                    .forEach(type -> {
                        try {
                            var servlet = context.createServlet(RootAppController.class);
                            var registration = context.addServlet("rootAppController", servlet);
                            registration.addMapping("/root");
                            registration.setLoadOnStartup(1);
                        } catch (ServletException ex) {
                            ex.printStackTrace();
                        }
                    });
        }


    }
}
