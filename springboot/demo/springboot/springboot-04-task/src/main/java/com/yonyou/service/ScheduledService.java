package com.yonyou.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/8.
 */
@Service
public class ScheduledService {

    @Scheduled(cron = "0 * * * * SUN-MON")
    public void hello() {
        System.out.println("hello...");
    }
}
