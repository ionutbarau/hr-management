package com.learn.hr.hrserver.employees.controllers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: hr-server
 * Date: 20/11/2016.
 * Time: 13:26
 * Marker annotation for classes which will be controllers for Employee.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HREmployeeController {
}
