package com.learn.hr.hrserver.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: angular-rest-spring-jpa-server
 * Date: 01/03/16.
 * Time: 21:18
 *
 * Class used  for configuration Spring DispatcherServlet in the servlet container (Java instead of XML).
 * It creates both a DispatcherServlet ((used for loading web application context))
 * and a ContextLoaderListener(used for loading backend application context).
 * SpringServletContainerInitializer implements Servlet 3.0 ServletContainerInitializer which is used for configuring the servlet container.
 * SpringServletContainerInitializer seeks any classes that implement WebApplicationInitializer and delegates to it for configuration.
 * AbstractAnnotationConfigDispatcherServletInitializer is an implementation of WebApplicationInitializer, so any class that extends it
 * will be automatically discovered when deployed in Servlet 3.0 container and will be used for configuring the servlet context.
 */
public class HRWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Used to load backend specific application context through backend specific configuration classes that holds only backend spring beans (@Service, @Repository).
     * @return array of backend config classes
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{HRConfigurationDev.class,HRConfigurationProd.class};
    }

    /**
     * Used to load web specific application context through web specific configuration classes that holds only web tier spring beans (@Controller, view resolver, handler mapping etc)
     * @return array of web config classes
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{HRWebConfiguration.class};
    }

    /**
     * Used for declaring of servlet mappings for DispatcherServlet.
     * @return string array of servlet mappings
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
