package com.learn.hr.hrserver.departments;

import com.learn.hr.hrserver.error.Rest400Exception;
import com.learn.hr.hrserver.error.Rest404Exception;
import com.learn.hr.hrserver.error.RestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by x01027037 on 16.03.2016.
 * Rest controller for Departments.
 */

@DepartmentApplicable
// Marks the class as being a rest controller
// If this annotation is applied, there is no need to use message converter annotation @ResponseBody to produce resource representation for client,
// because Spring will add message conversion capability by default for every handler method.
//If @Controller would be used (which works as a rest controller), message converter ResponseBody would be mandatory
//@RequestBody is mandatory in either case
@RestController
@RequestMapping("/rest/departments")
public class DepartmentRestControllerImpl implements DepartmentRestController {

    /**The department service */
    private DepartmentService departmentService;

    private Logger logger = LoggerFactory.getLogger(DepartmentControllerImpl.class);

    //Inject dependencies by type with @Autowired in constructor. (if there are multiple implementations of the same type use @Qualifier to narrow)
    @Autowired
    public DepartmentRestControllerImpl(DepartmentService departmentService){
        this.departmentService = departmentService;
    }


    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    @Override
    public @ResponseBody List<Department> getDepartments(@RequestParam(defaultValue = "0",name = "start") Integer start,
                                                         @RequestParam(defaultValue = "20",name = "count") Integer count) {
        List<Department> allDepartments = departmentService.getDepartments();
        List<Department> queryDepartments = new ArrayList<>();
        if(count > allDepartments.size()){
            throw new Rest400Exception("Bad request: count is bigger than the list size");
        }
        for(int i = start; i<count; i++){
            queryDepartments.add(allDepartments.get(i));
        }
        return queryDepartments;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public @ResponseBody Department addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return department;
    }

    @RequestMapping(path = "/httpheaders/",method = RequestMethod.POST,consumes = "application/json")
    @Override
    public ResponseEntity<Department> addDepartmentWithHttpHeaders(@RequestBody Department department, UriComponentsBuilder ucb) {
        HttpHeaders httpHeaders = new HttpHeaders();
        URI uri = ucb.path("/rest/departments/").path(String.valueOf(department.getDepartmentId())).build().toUri();
        httpHeaders.setLocation(uri);
        departmentService.addDepartment(department);
        ResponseEntity<Department> entity = new ResponseEntity<Department>(department,httpHeaders,HttpStatus.CREATED);
        return entity;
    }


    //ResponseEntity does message conversion automatically (it behaves like method return type was annotated with @ResponseBody)
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @Override
    public @ResponseBody Department getDepartmentById(@PathVariable("id") Long id) {
        Department department = departmentService.getDepartment(id);
        if(department == null){
            throw new Rest404Exception("Department with id = " + id + " not found");
        }
        return department;

    }

    //Marks the method a a class wide exception handler for methods that throw RestException
    /*@ExceptionHandler(RestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @Override
    public @ResponseBody Error handleErrors(RestException e) {
        Error error = new Error(e.getMessage());
        return error;
    }*/


    /*@ExceptionHandler(RestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody RestException handleErrors(RestException e) {
        return e;
    }*/

    @ExceptionHandler(Rest404Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    Map<Integer,String> handleNotFound(Rest404Exception e) {
        Map<Integer,String> map = new HashMap<>();
        map.put(e.getHttpStatus().value(),e.getMessage());
        return map;
    }

    @ExceptionHandler(Rest400Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Map<Integer,String> handleBadRequest(Rest400Exception e) {
        Map<Integer,String> map = new HashMap<>();
        map.put(e.getHttpStatus().value(),e.getMessage());
        return map;
    }


}
