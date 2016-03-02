package com.learn.hr.hrserver.configuration;

import com.learn.hr.hrserver.aspects.IAspect;
import com.learn.hr.hrserver.departments.IDepartment;
import com.learn.hr.hrserver.employees.IEmployee;
import com.learn.hr.hrserver.salaries.ISalary;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: angular-rest-spring-jpa-server
 * Date: 22/02/16.
 * Time: 21:05
 *
 * Production profile spring backend configuration class.
 */
//Marks the class as Spring config Java class (used instead of xml config)
@Configuration
//Defines the properties file path
@PropertySource(HRConstants.HR_PROPERTIES_CLASSPATH)
//Defines the profile used in order for this configuration class to be loaded eg "development"
@Profile(HRConstants.PRODUCTION_PROFILE)
//Activates component scanning for classes that are in packages where the listed classes belong
@ComponentScan(basePackageClasses = {IDepartment.class, ISalary.class, IEmployee.class, IAspect.class})
//Enables Spring AOP
@EnableAspectJAutoProxy
public class HRConfigurationProd{

    /**
     * Used for wiring properties with placeholder values eg @Value("${app.title}"). It is not needed if we use SpEL which
     * can be used the following way: @Value("#{environment.getProperty('app.title')}").
     * @return PropertySourcesPlaceholderConfigurer instance
     */
    @Bean
    public
    static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
