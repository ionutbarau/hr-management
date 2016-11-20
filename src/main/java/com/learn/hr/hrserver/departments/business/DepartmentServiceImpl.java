package com.learn.hr.hrserver.departments.business;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by x01027037 on 03.03.2016.
 * Te service class implementation for {@link DepartmentService}.
 */
//Marks the class as being department business related.
@HRDepartmentBusiness
//Marks the class as being a Spring service
@Service
public class DepartmentServiceImpl implements DepartmentService {

    public DepartmentServiceImpl(){
        System.out.println("========= DepartmentServiceImpl instantiated =========");
    }

    private List<Department> departments;

    /**
     * This method is called upon initialization.
     */
    @PostConstruct
    public void init(){
        departments = new ArrayList<>();
        for(int i = 0;i<20; i++){
            Department d = new Department();
            d.setDepartmentId(Long.valueOf(i));
            d.setDepartmentName("Department" + i);
            departments.add(d);
        }

    }

    @Override
    public List<Department> getDepartments() {
        return departments;
    }
}
