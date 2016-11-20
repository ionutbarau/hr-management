package com.learn.hr.hrserver.departments.business;

import java.util.List;

/**
 * Created by x01027037 on 03.03.2016.
 */
public interface DepartmentService {

     List<Department> getDepartments();

     boolean addDepartment(Department d);

     Department getDepartment(Long id);

}
