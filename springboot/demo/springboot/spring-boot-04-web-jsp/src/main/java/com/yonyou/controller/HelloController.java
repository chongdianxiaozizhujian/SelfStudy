package com.yonyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2018/6/24.
 */

@Controller
public class HelloController {
    @GetMapping("/abc")
    public String hello(Model model) {
        model.addAttribute("msg", "你好");
        return "success";
    }
}
