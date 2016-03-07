package com.learn.hr.hrserver.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by x01027037 on 07.03.2016.
 */
@DepartmentApplicable
//Marks the class to be a MVC controller
@Controller
//Class level request mapping
@RequestMapping(value = "/departments")
public class DepartmentControllerImpl implements DepartmentController {


    private DepartmentService departmentService;

    @Autowired
    public DepartmentControllerImpl(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public String departments(Map model) {
        model.put("departments", departmentService.getDepartments());
        return "departments";
    }


}
