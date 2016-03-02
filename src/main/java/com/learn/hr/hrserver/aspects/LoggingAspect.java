package com.learn.hr.hrserver.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: angular-rest-spring-jpa-server
 * Date: 26/02/16.
 * Time: 20:04
 */
public interface LoggingAspect extends IAspect {


    /**
     * The advice method is called before the advised (target) method is called.
     */
    public void logBeforeMethod(JoinPoint jp);

    /**
     * The advice method is called after the advised (target) method returns or throws an exception.
     */
    public void logAfterMethod(JoinPoint jp);

    /**
     * The advice method is called before the advised (target) method returns.
     */
    public void logAfterMethodReturn(JoinPoint jp);

    /**
     * The advice method is called before the advised (target) method throws and exception.
     */
    public void logAfterMethodException(JoinPoint jp);

    /**
     * The advice method wraps the advised (target) method is called.
     * This method can be used instead of all others because it encapsulates functionality for all of them.
     */
    public void logAroundMethod(ProceedingJoinPoint jp);




}
