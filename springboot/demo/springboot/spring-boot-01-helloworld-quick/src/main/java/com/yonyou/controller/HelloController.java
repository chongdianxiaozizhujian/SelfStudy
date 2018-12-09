package com.yonyou.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/28.
 */
/*@ResponseBody
@Controller*/
@RestController
public class HelloController {
    //@ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
