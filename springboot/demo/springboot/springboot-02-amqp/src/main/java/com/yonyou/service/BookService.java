package com.yonyou.service;

import com.yonyou.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/4.
 */

@Service
public class BookService {

    @RabbitListener(queues = "yonyou.news")
    public void receive(Book book) {
        System.out.println("收到消息" + book);
    }

    @RabbitListener(queues = "yonyou")
    public void receive2(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
