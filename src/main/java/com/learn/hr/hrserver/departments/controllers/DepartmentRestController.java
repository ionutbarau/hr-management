package com.learn.hr.hrserver.departments.controllers;

import com.learn.hr.hrserver.departments.business.Department;
import com.learn.hr.hrserver.error.RestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by x01027037 on 16.03.2016.
 */
public interface DepartmentRestController {

    List<Department> getDepartments(Integer start, Integer count);

    Department addDepartment(Department department);

    ResponseEntity<Department> addDepartmentWithHttpHeaders(Department department, UriComponentsBuilder ucb);

    Department getDepartmentById(Long id);

    //public Error handleErrors(RestException e);



}
