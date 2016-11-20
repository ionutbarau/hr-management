package com.learn.hr.hrserver.test.departments.controllers;

import com.learn.hr.hrserver.departments.business.Department;
import com.learn.hr.hrserver.departments.controllers.DepartmentControllerImpl;
import com.learn.hr.hrserver.departments.business.DepartmentService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by x01027037 on 07.03.2016.
 */
public class DepartmentControllerTest {

    @Test
    public void testDepartments() throws Exception {
        List<Department> departmentList = buildDepartments();
        DepartmentService mockDepartmentService = Mockito.mock(DepartmentService.class);
        DepartmentControllerImpl departmentController = new DepartmentControllerImpl(mockDepartmentService);
        Mockito.when(mockDepartmentService.getDepartments()).thenReturn(departmentList);
        //setSingleView is used when the controller path is the same as the view name. (The mock framework tries to resolve view name coming from controller on its own).
        //Solves javax.servlet.ServletException: Circular view path
        MockMvc mockMvc = standaloneSetup(departmentController).setSingleView(new InternalResourceView("/WEB-INF/views/departments.jsp")).build();
        mockMvc.perform(get("/departments")).
                andExpect(view().name("departments")).
                andExpect(model().attributeExists("departments"));
    }

    @Test
    public void testDepartmentsPagination() throws Exception {
        List<Department> departmentList = buildDepartments();
        DepartmentService mockDepartmentService = Mockito.mock(DepartmentService.class);
        Mockito.when(mockDepartmentService.getDepartments()).thenReturn(departmentList);
        DepartmentControllerImpl departmentController = new DepartmentControllerImpl(mockDepartmentService);
        //setSingleView is used when the controller path is the same as the view name. (The mock framework tries to resolve view name coming from controller on its own).
        //Solves javax.servlet.ServletException: Circular view path
        MockMvc mockMvc = standaloneSetup(departmentController).setSingleView(new InternalResourceView("/WEB-INF/views/departments.jsp")).build();


        mockMvc.perform(get("/departments/paging?start=0&count=10")).
                andExpect(view().name("departments")).
                andExpect(model().attributeExists("departments")).
                andExpect(model().attribute("departments",build10Departments()));
    }

    private List<Department> buildDepartments(){
        List<Department> departments = new ArrayList<>();
        for(int i = 0;i<20; i++){
            Department d = new Department();
            d.setDepartmentId(Long.valueOf(i));
            d.setDepartmentName("Department" + i);
            departments.add(d);
        }
        return departments;
    }

    private List<Department> build10Departments(){
        List<Department> departments = new ArrayList<>();
        for(int i = 0;i<10; i++){
            Department d = new Department();
            d.setDepartmentId(Long.valueOf(i));
            d.setDepartmentName("Department" + i);
            departments.add(d);
        }
        return departments;
    }
}
