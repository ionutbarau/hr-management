package com.learn.hr.hrserver.departments;

import com.learn.hr.hrserver.error.RestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by x01027037 on 16.03.2016.
 */
public interface DepartmentRestController {

    public List<Department> getDepartments(Integer start, Integer count);

    public Department addDepartment(Department department);

    public ResponseEntity<Department> addDepartmentWithHttpHeaders(Department department, UriComponentsBuilder ucb);

    public Department getDepartmentById(Long id);

    //public Error handleErrors(RestException e);



}
