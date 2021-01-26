package com.aktarulahsan.erp.core.base;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping("/")
    public String index() {
        return "Congratulations from BlogController.java";
    }



}
