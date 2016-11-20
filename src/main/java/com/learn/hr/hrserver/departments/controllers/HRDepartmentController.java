package com.learn.hr.hrserver.departments.controllers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: hr-server
 * Date: 20/11/2016.
 * Time: 13:21
 * Marker annotation for classes which will be controllers for Departments.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HRDepartmentController {
}
