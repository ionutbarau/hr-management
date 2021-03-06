package com.learn.hr.hrserver.departments.controllers;

import com.learn.hr.hrserver.departments.business.Department;
import com.learn.hr.hrserver.departments.business.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by x01027037 on 07.03.2016.
 */

//Marks the class as being department controller related.
@HRDepartmentController
//Marks the class to be a MVC controller
@Controller
//Class level request mapping
@RequestMapping(value = "/departments")
public class DepartmentControllerImpl implements DepartmentController {

    /**The department service */
    private DepartmentService departmentService;

    //Inject dependencies by type with @Autowired in constructor. (if there are multiple implementations of the same type use @Qualifier to narrow)
    @Autowired
    public DepartmentControllerImpl(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    //Method level request mapping.(Together with class level request mapping forms the request path and method use to access this method )
    @RequestMapping(method = RequestMethod.GET)
    @Override
    public String departments(Map model) {
        model.put("departments", departmentService.getDepartments());
        return "departments";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/paging")
    @Override
    public String departments(@RequestParam(defaultValue = "0",name = "start") Integer start,
                              @RequestParam(defaultValue = "20",name = "count") Integer count,
                              Map model) {
        List<Department> allDepartments = departmentService.getDepartments();
        List<Department> queryDepartments = new ArrayList<>();
        for(int i = start; i<count; i++){
            queryDepartments.add(allDepartments.get(i));
        }
        model.put("departments", queryDepartments);
        return "departments";
    }

    @Override
    public String getDepartments(Long id, Map model) {
        return null;
    }

    @Override
    public String goToAddDepartments() {
        return null;
    }

    @Override
    public String addDepartment(Department d, Errors errors, Map model) {
        return null;
    }


}
