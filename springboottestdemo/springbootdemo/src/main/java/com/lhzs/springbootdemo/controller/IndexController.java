package com.lhzs.springbootdemo.controller;

import com.lhzs.springbootdemo.model.PublicUsersModel;
import com.lhzs.springbootdemo.model.ResponseModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "index")
    public String indexView(){
        return "index";
    }

    @RequestMapping(value = "upDataPassword")
    public String upDataPassword(){
        return "updata_password";
    }
}
