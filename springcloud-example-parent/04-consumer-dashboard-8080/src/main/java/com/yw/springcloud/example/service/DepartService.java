package com.yw.springcloud.example.service;

import com.yw.springcloud.example.component.DepartFallback;
import com.yw.springcloud.example.component.DepartFallbackFactory;
import com.yw.springcloud.example.po.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangwei
 */
// 指定该Service绑定的微服务名称，以及降级处理类
@FeignClient(value = "msc-provider-depart",
//        fallback = DepartFallback.class)
        fallbackFactory = DepartFallbackFactory.class)
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
