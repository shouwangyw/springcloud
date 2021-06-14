package com.yw.springcloud.example.controller;

import com.yw.springcloud.example.po.Depart;
import com.yw.springcloud.example.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangwei
 */
@RestController
@RequestMapping("/provider/depart")
public class DepartController {
    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        return departService.saveOne(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
        return departService.deleteById(id);
    }

    @PutMapping("/update")
    public boolean updateHandle(@RequestBody Depart depart) {
        return departService.updateOne(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departService.listDeparts();
    }

    // 声明服务发现客户端
    @Autowired
    private DiscoveryClient client;

    @GetMapping("/discovery")
    public Object discoveryHandle() {
        // 获取Eureka中所有的微服务名称
        List<String> serviceNames = client.getServices();
        // 遍历
        for (String name : serviceNames) {
            // 根据微服务名称获取所有提供该服务的主机信息
            List<ServiceInstance> instances = client.getInstances(name);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getHost() + " : " + instance.getPort());
            }
        }
        return serviceNames;
    }
}
