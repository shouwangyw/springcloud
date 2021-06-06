package com.yw.springcloud.example.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.yw.springcloud.example.lbrule.CustomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangwei
 * @date 2021-06-06 23:08
 */
@Configuration
public class ConsumerConfig {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    // 指定Ribbon使用随即算法策略
//    @Bean
//    public IRule loadBalanceRule() {
//        return new RandomRule();
//    }

    // 指定Ribbon使用自定义负载均衡策略
    @Bean
    public IRule loadBalanceRule(){
        List<Integer> ports = new ArrayList<>();
        ports.add(8091);
        return new CustomRule(ports);
    }
}
