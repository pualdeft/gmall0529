package com.atguigu.gmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageController {
    @RequestMapping(value = "main" )
    public String index(){

        return "main";
    }
}
