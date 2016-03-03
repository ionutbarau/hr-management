package com.learn.hr.hrserver.employees;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: hr-server
 * Date: 02/03/16.
 * Time: 21:13
 *
 * Marker annotation for employee related business classes.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EmployeeApplicable {
}
