package org.launchcode.neighborgoods.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

    @GetMapping(value = "/logoutconfirm")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "logoutconfirm";
    }
}
