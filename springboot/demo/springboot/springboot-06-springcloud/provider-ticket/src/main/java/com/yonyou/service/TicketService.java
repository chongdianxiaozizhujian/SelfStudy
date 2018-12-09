package com.yonyou.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/12.
 */
@Service
public class TicketService {
    public String getTicket() {
        System.out.println("8002 .....");
        return "动物世界";
    }
}
