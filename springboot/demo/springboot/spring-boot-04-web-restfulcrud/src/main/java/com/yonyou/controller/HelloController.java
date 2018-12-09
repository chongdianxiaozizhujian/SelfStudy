package com.yonyou.controller;

import com.yonyou.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/10.
 */
@Controller
public class HelloController {

    /*@RequestMapping({"/","/index.html"})
    public String index() {
        return "index";
    }*/

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(@RequestParam("user") String user) {
        if(user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "hello";
    }


    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("张三","李四","王五"));
        return "success";
    }
}
