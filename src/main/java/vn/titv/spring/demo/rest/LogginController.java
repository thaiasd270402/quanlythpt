package vn.titv.spring.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogginController {
    @GetMapping("/showLoginPage")
    public String showLoginOage(){
        return "login/login";
    }

    @GetMapping("/showPage403")
    public String showPage403(){
        return "error/403";
    }
}
