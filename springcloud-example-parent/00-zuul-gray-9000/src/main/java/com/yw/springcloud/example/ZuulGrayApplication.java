package com.yw.springcloud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author yangwei
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulGrayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGrayApplication.class, args);
    }
}
