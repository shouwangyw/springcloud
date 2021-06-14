package com.yw.springcloud.example.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class StreamListenerConsumer {
    @StreamListener(Sink.INPUT)
    public void printMsg(Object message) {
        System.out.println("@StreamListener --- " + message);
    }
}