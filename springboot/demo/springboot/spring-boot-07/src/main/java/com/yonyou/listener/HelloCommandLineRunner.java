package com.yonyou.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/6/28.
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("HelloCommandLineRunner" + Arrays.asList(strings));
    }
}
