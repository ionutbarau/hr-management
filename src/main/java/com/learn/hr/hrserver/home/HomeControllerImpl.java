package com.learn.hr.hrserver.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by x01027037 on 04.03.2016.
 */
@HRHomeController
@Controller
@RequestMapping(value = {"/", "/homepage"})
public class HomeControllerImpl implements HomeController{

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public String goToHome() {
        return "home";
    }
}
