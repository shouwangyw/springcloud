package com.yw.springcloud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangwei
 */
@EnableFeignClients
@EnableCircuitBreaker   // 开启熔断器
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ConsumerConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConfigApplication.class, args);
    }

    @LoadBalanced // 开启消费者客户端的负载均衡功能
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
