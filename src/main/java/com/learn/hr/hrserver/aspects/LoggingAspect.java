package com.learn.hr.hrserver.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: angular-rest-spring-jpa-server
 * Date: 26/02/16.
 * Time: 20:04
 */
public interface LoggingAspect {


    /**
     * The advice method is called before the advised (target) method is called.
     */
    void logBeforeMethod(JoinPoint jp);

    /**
     * The advice method is called after the advised (target) method returns or throws an exception.
     */
    void logAfterMethod(JoinPoint jp);

    /**
     * The advice method is called before the advised (target) method returns.
     */
    void logAfterMethodReturn(JoinPoint jp);

    /**
     * The advice method is called before the advised (target) method throws and exception.
     */
    void logAfterMethodException(JoinPoint jp);

    /**
     * The advice method wraps the advised (target) method is called.
     * This method can be used instead of all others because it encapsulates functionality for all of them.
     */
    Object logAroundMethod(ProceedingJoinPoint jp);




}
