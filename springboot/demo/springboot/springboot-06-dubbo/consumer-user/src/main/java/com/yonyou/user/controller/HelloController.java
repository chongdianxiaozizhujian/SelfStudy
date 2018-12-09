package com.yonyou.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yonyou.ticket.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/12.
 */
@RestController
public class HelloController {

    @Reference
    TicketService ticketService;

    @GetMapping("/hello")
    private String hello() {
        return ticketService.getTicket();
    }

}
