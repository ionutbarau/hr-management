package com.learn.hr.hrserver.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: angular-rest-spring-jpa-server
 * Date: 26/02/16.
 * Time: 20:15
 */
//Marks this class to be an AspectJ AOP aspect.
//Spring borrows annotations from AspectJ to use in Spring's AOP proxy based method interception.
@Aspect
//Marks this class to be a spring bean.
@Component
public class LoggingAspectImpl implements LoggingAspect {

    /**
     * Declares AspectJ pointcut for methods in classes belonging to departments package.
     */
    @Pointcut("execution(* com.learn.hr.hrserver.departments..*(..))")
    public void departmentsPointcut(){}

    /**
     * Declares AspectJ pointcut for methods in classes belonging to employees package.
     */
    @Pointcut("execution(* com.learn.hr.hrserver.employees..*(..))")
    public void employeesPointcut(){}

    /**
     * Declares AspectJ pointcut for methods in classes belonging to salaries package.
     */
    @Pointcut("execution(* com.learn.hr.hrserver.salaries..*(..))")
    public void salariesPointcut(){}

    //Declares the AspectJ @Before method interceptor advice.
    @Before("departmentsPointcut() || employeesPointcut() || salariesPointcut()")
    public void logBeforeMethod(JoinPoint jp) {
        System.out.println("@Before advice called");
    }

    //Declares the AspectJ @After method interceptor advice.
    @After("departmentsPointcut() || employeesPointcut() || salariesPointcut()")
    public void logAfterMethod(JoinPoint jp) {
        System.out.println("@After advice called");
    }

    //Declares the AspectJ @AfterReturning method interceptor advice.
    @AfterReturning("departmentsPointcut() || employeesPointcut() || salariesPointcut()")
    public void logAfterMethodReturn(JoinPoint jp) {
        System.out.println("@AfterReturning advice called");
    }


    //Declares the AspectJ @AfterThrowing method interceptor advice.
    @AfterThrowing("departmentsPointcut() || employeesPointcut() || salariesPointcut()")
    public void logAfterMethodException(JoinPoint jp) {
        System.out.println("@AfterThrowing advice called");
    }


     //Declares the AspectJ @Around method interceptor advice.
    @Around("departmentsPointcut() || employeesPointcut() || salariesPointcut()")
    public void logAroundMethod(ProceedingJoinPoint jp) {
        try {
            System.out.println("@Around advice start");
            jp.proceed();
            System.out.println("@Around advice finish");
        } catch (Throwable throwable) {
            System.out.println("@Around advice caught error: " + throwable.getMessage());
            throwable.printStackTrace();
        }
    }
}
