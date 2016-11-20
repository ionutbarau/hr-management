package com.learn.hr.hrserver.configuration;

import com.learn.hr.hrserver.departments.controllers.HRDepartmentController;
import com.learn.hr.hrserver.employees.controllers.HREmployeeController;
import com.learn.hr.hrserver.home.HRHomeController;
import com.learn.hr.hrserver.salaries.controllers.HRSalaryController;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: angular-rest-spring-jpa-server
 * Date: 01/03/16.
 * Time: 22:29
 *
 * Spring web mvc configuration class. (No need for profile dependent config classes here).
 * WebMvcConfigurerAdapter is extended in order to implement configureDefaultServletHandling in order to forward requests for  static resources to the
 * container's default servlet.
 */
//Marks the class as Spring config Java class (used instead of xml config)
@Configuration
//Enables support for handling components marked with AspectJ's @Aspect annotation.
@EnableWebMvc
//Activates component scanning for classes that are in packages where the listed classes belong
@ComponentScan(basePackageClasses = {HRHomeController.class, HRDepartmentController.class, HREmployeeController.class, HRSalaryController.class})
public class HRWebConfiguration extends WebMvcConfigurerAdapter {

    /**
     * JSP view resolver. If no view resolver is configured, Spring will default to using BeanNameViewResolver, a view resolver that resolves views by looking for beans whose
     * ID matches the view name and whose class implements the View interface
     * @return a view resolver instance
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * By enabling DefaultServletHandlerConfigurer, DispatcherServlet forwards requests for static resources to
     * the container's default servlet.
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
