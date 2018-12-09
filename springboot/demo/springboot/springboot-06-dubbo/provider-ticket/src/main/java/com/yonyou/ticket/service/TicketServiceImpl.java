package com.yonyou.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/8.
 */
@Service
@Component
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "动物世界";
    }
}
