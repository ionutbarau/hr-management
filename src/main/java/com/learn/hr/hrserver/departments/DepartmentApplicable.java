package com.learn.hr.hrserver.departments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Ionut Barau (ionutbarau)
 * Project: hr-server
 * Date: 02/03/16.
 * Time: 21:12
 *
 * Marker annotation for department related business classes.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DepartmentApplicable {
}
