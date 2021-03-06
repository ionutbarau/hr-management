package com.learn.hr.hrserver.configuration;


import com.learn.hr.hrserver.aspects.HRAspect;
import com.learn.hr.hrserver.departments.business.HRDepartmentBusiness;
import com.learn.hr.hrserver.employees.business.HREmployeeBusiness;
import com.learn.hr.hrserver.salaries.business.HRSalaryBusiness;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


/**
 * User: Ionut Barau (ionutbarau)
 * Project: angular-rest-spring-jpa-server
 * Date: 22/02/16.
 * Time: 13:16
 *
 * Development profile spring backend configuration class.
 */
//Marks the class as Spring config Java class (used instead of xml config)
@Configuration
//Defines the properties file path
@PropertySource(HRConstants.HR_PROPERTIES_CLASSPATH)
//Defines the profile used in order for this configuration class to be loaded eg "development"
@Profile(HRConstants.DEVELOPMENT_PROFILE)
//Activates component scanning for classes that are in packages where the listed classes belong
@ComponentScan(basePackageClasses = {HRDepartmentBusiness.class, HRSalaryBusiness.class, HREmployeeBusiness.class, HRAspect.class})
//Enables support for handling components marked with AspectJ's @Aspect annotation.
@EnableAspectJAutoProxy
public class HRConfigurationDev{


    public HRConfigurationDev(){
        System.out.println("====== Loading DEV configuration ======");
    }

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
