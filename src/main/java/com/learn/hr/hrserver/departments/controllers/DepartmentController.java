package com.learn.hr.hrserver.departments.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Map;

/**
 * Created by x01027037 on 07.03.2016.
 * Interface for department controller.
 */
public interface DepartmentController {

    public String departments(Map model);

    public String departments(Integer start,Integer count,Map model);

    public String getDepartments(Long id, Map model);

    public String goToAddDepartments();

    public String addDepartment(Department d,Errors errors,Map model);

}
