package com.learn.hr.hrserver.test.home;

import com.learn.hr.hrserver.configuration.HRWebConfiguration;
import com.learn.hr.hrserver.home.HomeController;
import com.learn.hr.hrserver.home.HomeControllerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.Assert.*;


/**
 * Created by x01027037 on 04.03.2016.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = HRWebConfiguration.class)*/
public class HomeControllerTest {

    @Test
    public void testGoToHome() throws Exception {
        HomeControllerImpl homeController = new HomeControllerImpl();
        MockMvc mockMvc = standaloneSetup(homeController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
        mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
    }
}
