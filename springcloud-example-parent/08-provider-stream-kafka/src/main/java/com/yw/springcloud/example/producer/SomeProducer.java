package com.yw.springcloud.example.producer;

import com.yw.springcloud.example.source.CustomSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author yangwei
 */
// Spring Cloud 中的 Source 类，将MQ与生产者类通过消息管道想绑定
@EnableBinding({Source.class, CustomSource.class})
@Component
public class SomeProducer {
    // 必须使用byName方式注入消息管道，系统中还定义了名称为 nullChannel、errorChannel 的两个同类型的管道
    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel channel;

    @Autowired
    @Qualifier(CustomSource.CHANNEL_NAME)
    private MessageChannel customChannel;

    public void sendMsg(String message) {
        // 通过消息管道发送消息，即消息写入到消息管道，再通过管道写入到 MQ
        channel.send(MessageBuilder.withPayload(message).build());
        customChannel.send(MessageBuilder.withPayload(message).build());
    }
}
