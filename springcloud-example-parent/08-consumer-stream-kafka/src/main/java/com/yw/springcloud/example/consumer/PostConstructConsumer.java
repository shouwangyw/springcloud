package com.yw.springcloud.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author yangwei
 */
//@Component
//@EnableBinding(Sink.class)
public class PostConstructConsumer {
    @Autowired
    @Qualifier(Sink.INPUT)
    private SubscribableChannel channel;

    @PostConstruct
    public void receiveMsg() {
        channel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println("@PostConstruct --- " + message.getHeaders() + ", ");
                byte[] payload = (byte[]) message.getPayload();
                System.out.println(new String(payload));
            }
        });
    }
}
