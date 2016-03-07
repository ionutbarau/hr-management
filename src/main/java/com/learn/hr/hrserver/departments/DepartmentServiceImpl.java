package com.learn.hr.hrserver.departments;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by x01027037 on 03.03.2016.
 */
@DepartmentApplicable
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    private List<Department> departments;

    @PostConstruct
    public void init(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%% post construct called");
        departments = new ArrayList<>();
        Department d1 = new Department();
        d1.setDepartmentId(1l);
        d1.setDepartmentName("Department1");
        Department d2 = new Department();
        d2.setDepartmentId(2l);
        d2.setDepartmentName("Department2");
        departments.add(d1);
        departments.add(d2);
    }

    @Override
    public List<Department> getDepartments() {
        return departments;
    }
}
