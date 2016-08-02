package com.upsoft.semantic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2016/8/2.
 */
@Controller
public class Test {
    private static Logger LOG = LoggerFactory.getLogger(Test.class);
    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        if(LOG.isDebugEnabled()) {
            LOG.debug("access test");
        }
        return  "test";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
