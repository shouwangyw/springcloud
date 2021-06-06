package com.yw.springcloud.example.service;

import com.yw.springcloud.example.po.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangwei
 */
@FeignClient("msc-provider-depart") // 指定Service绑定的微服务名称
@RequestMapping("/provider/depart")
public interface DepartService {
    @PostMapping("/save")
    boolean saveOne(Depart depart);
    @DeleteMapping("/del/{id}")
    boolean deleteById(@PathVariable("id") int id);
    @PutMapping("/update")
    boolean updateOne(Depart depart);
    @GetMapping("/get/{id}")
    Depart getDepartById(@PathVariable("id") int id);
    @GetMapping("/list")
    List<Depart> listDeparts();
}
