package com.learn.hr.hrserver.salaries.controllers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: hr-server
 * Date: 20/11/2016.
 * Time: 13:27
 * Marker annotation for classes which will controllers for Salary.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HRSalaryController {
}
