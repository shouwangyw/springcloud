package com.yw.springcloud.example.controller;

import com.yw.springcloud.example.po.Depart;
import com.yw.springcloud.example.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangwei
 */
@RefreshScope
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    @Autowired
    private DepartService departService;

    @Value("${prefix}")
    private String prefix;

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

    //    @HystrixCommand(fallbackMethod = "getHystrixHandle")
    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        Depart depart = departService.getDepartById(id);
        return depart.setName(prefix + depart.getName());
    }

    private Depart getHystrixHandle(@PathVariable("id") int id) {
        return new Depart()
                .setId(id)
                .setName("【Hystrix】No this depart -- 方法级别");
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departService.listDeparts();
    }
}
