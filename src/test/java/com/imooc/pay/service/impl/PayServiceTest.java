package com.imooc.pay.service.impl;

import com.imooc.pay.PayApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private PayServiceImpl payService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void creat() {
        payService.creat("12345dsad6dssa", BigDecimal.valueOf(0.01));
    }

    @Test
    public void sendMQMsg() {
        amqpTemplate.convertAndSend("payNotify", "hello");
    }
}