package com.yw.springcloud.example.controller;

import com.yw.springcloud.example.po.Depart;
import com.yw.springcloud.example.service.DepartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangwei
 */
@Slf4j
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    /**
     * 这里的DepartService是FeignClient，并不是真正的业务接口
     */
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
        log.info("消费者的处理器方法被调用");
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departService.listDeparts();
    }
}
