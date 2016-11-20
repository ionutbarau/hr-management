package com.learn.hr.hrserver.main;

import com.learn.hr.hrserver.configuration.HRConfigurationDev;
import com.learn.hr.hrserver.configuration.HRConfigurationProd;
import com.learn.hr.hrserver.configuration.HRConstants;
import com.learn.hr.hrserver.configuration.HRWebConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by x01027037 on 16.03.2016.
 */
public class TestMain {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setDefaultProfiles(HRConstants.DEVELOPMENT_PROFILE);
        context.register(HRConfigurationDev.class);
        context.refresh();
        Iterator i = context.getBeanFactory().getBeanNamesIterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }


    }

}

