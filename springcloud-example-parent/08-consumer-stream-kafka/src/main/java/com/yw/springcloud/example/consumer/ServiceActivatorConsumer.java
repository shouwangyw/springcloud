package com.yw.springcloud.example.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * @author yangwei
 */
//@Component
//@EnableBinding(Sink.class)
public class ServiceActivatorConsumer {
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receiveMsg(Object message) {
        System.out.println("@ServiceActivator --- " + message);
    }
}
