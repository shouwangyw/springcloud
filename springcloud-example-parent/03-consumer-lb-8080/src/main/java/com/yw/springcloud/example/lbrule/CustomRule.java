package com.yw.springcloud.example.lbrule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author yangwei
 * @date 2021-06-06 23:11
 */
public class CustomRule implements IRule {
    private ILoadBalancer lb;
    // 要排除的提供者的服务端口号
    private List<Integer> excludePorts;

    public CustomRule() {
    }

    public CustomRule(List<Integer> excludePorts) {
        this.excludePorts = excludePorts;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }

    @Override
    public Server choose(Object key) {
        // 获取所有可用的提供者主机
        List<Server> servers = lb.getReachableServers();
        // 获取所有排除了指定端口号的提供者
        List<Server> availableServers = this.getAvailableServers(servers);
        // 从剩余的提供者中随机获取可用的提供者
        return this.getAvailableRandomServers(availableServers);
    }

    // 获取所有排除了指定端口号的提供者
    private List<Server> getAvailableServers(List<Server> servers) {
        // 若没有要排除的主机，则返回所有
        if (excludePorts == null || excludePorts.size() == 0) {
            return servers;
        }
        return servers.stream()
                .filter(server -> excludePorts.stream().noneMatch(port -> server.getPort() == port))
                .collect(Collectors.toList());
    }

    // 从剩余的提供者中随机获取可用的提供者
    private Server getAvailableRandomServers(List<Server> availableServers) {
        // 获取一个[0，availableServers.size())的随机数
        int index = new Random().nextInt(availableServers.size());
        return availableServers.get(index);
    }
}
