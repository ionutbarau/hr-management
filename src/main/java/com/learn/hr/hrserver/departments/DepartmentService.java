package com.learn.hr.hrserver.departments;

import java.util.List;

/**
 * Created by x01027037 on 03.03.2016.
 */
public interface DepartmentService {

    public List<Department> getDepartments();

    public Department getDepartment(Long id);

    public void addDepartment(Department d);
}
