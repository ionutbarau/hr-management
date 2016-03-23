package com.learn.hr.hrserver.departments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by x01027037 on 07.03.2016.
 */
//Marks the class as being department related.
@DepartmentApplicable
//Marks the class to be a MVC controller
@Controller
//Class level request mapping
@RequestMapping(value = "/departments")
public class DepartmentControllerImpl implements DepartmentController {

    /**The department service */
    private DepartmentService departmentService;

    private Logger logger = LoggerFactory.getLogger(DepartmentControllerImpl.class);

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
    public String departments(@RequestParam(defaultValue = "0",name = "start") Integer start, //Request parameters like @QueryParam in JAX-RS (?start=0&count=20)
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

    //Defines a resource path like @Path in JAX-RS (/department/1)
    @RequestMapping(value = "/department/{id}")
    @Override
    public String getDepartments(@PathVariable(value = "id")Long id,//Defines the path parameter variable like @PathParam in JAX-RS
                                 Map model) {
        List<Department> allDepartments = departmentService.getDepartments();
        model.put("department",allDepartments.get(id.intValue()));
        return "department";
    }

    @Override
    @RequestMapping(value = "/addDepartment",method = RequestMethod.GET)
    public String goToAddDepartments() {
        return "addDepartment";
    }

    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    @Override
    public String addDepartment(@Valid Department d, //No need to do mapping because the names of the request params are the same as the names of the fields.@Valid is use to trigger Java validation API
    Errors errors,Map model) {
        if(errors.hasErrors()){
            for (ObjectError er : errors.getAllErrors()){
                System.out.println(er.getDefaultMessage());
            }
            model.put("errors", errors);
            return "error";
        }
        departmentService.addDepartment(d);
        return "redirect:/departments/department/" + d.getDepartmentId();
    }


}
