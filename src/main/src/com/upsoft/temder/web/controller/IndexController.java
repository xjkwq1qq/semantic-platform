package com.upsoft.temder.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2016/8/5.
 */
@Controller
public class IndexController {
    @RequestMapping("/toindex")
    public String toindex(){
        return "index";
    }


    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
