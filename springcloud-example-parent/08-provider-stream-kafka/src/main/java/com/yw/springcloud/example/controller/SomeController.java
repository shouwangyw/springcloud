package com.yw.springcloud.example.controller;

import com.yw.springcloud.example.producer.SomeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangwei
 * @date 2021-06-14 21:54
 */
@RestController
public class SomeController {
    @Autowired
    private SomeProducer producer;

    /**
     * 发送单条消息给一个主题
     */
    @PostMapping("/msg/send")
    public String sendMsg(@RequestParam("message") String message) {
        producer.sendMsg(message);
        return "send success";
    }
}
