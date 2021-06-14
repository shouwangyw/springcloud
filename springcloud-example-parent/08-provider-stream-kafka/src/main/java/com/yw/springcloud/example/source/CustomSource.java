package com.yw.springcloud.example.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author yangwei
 */
public interface CustomSource {
    String CHANNEL_NAME = "xxx";
    @Output(CustomSource.CHANNEL_NAME)
    MessageChannel output();
}
