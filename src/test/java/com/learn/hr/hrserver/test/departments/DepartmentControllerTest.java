package com.learn.hr.hrserver.test.departments;

import com.learn.hr.hrserver.departments.Department;
import com.learn.hr.hrserver.departments.DepartmentController;
import com.learn.hr.hrserver.departments.DepartmentControllerImpl;
import com.learn.hr.hrserver.departments.DepartmentService;
import com.learn.hr.hrserver.home.HomeControllerImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.env.MockEnvironment;
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
        //setSingleView is used when the controller path is the same as the view name. (The mock framework tries to resolve view name coming from controller on its own).
        //Solves javax.servlet.ServletException: Circular view path
        MockMvc mockMvc = standaloneSetup(departmentController).setSingleView(new InternalResourceView("/WEB-INF/views/departments.jsp")).build();
        mockMvc.perform(get("/departments")).
                andExpect(view().name("departments")).
                andExpect(model().attributeExists("departments"));
    }

    private List<Department> buildDepartments(){
        List<Department> departments = new ArrayList<>();
        Department d1 = new Department();
        d1.setDepartmentId(1l);
        d1.setDepartmentName("Department1");
        Department d2 = new Department();
        d2.setDepartmentId(2l);
        d2.setDepartmentName("Department2");
        departments.add(d1);
        departments.add(d2);
        return departments;
    }
}
