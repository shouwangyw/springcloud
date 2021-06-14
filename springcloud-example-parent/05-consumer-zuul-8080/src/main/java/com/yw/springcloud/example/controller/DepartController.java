package com.yw.springcloud.example.controller;

import com.yw.springcloud.example.po.Depart;
import com.yw.springcloud.example.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yangwei
 */
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    /**
     * 这里的DepartService是FeignClient，并不是真正的业务接口
     */
    @Autowired
    private DepartService departService;
    @Value("${server.port}")
    private int port;

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
    public Depart getHandle(@PathVariable("id") int id, HttpServletRequest request) {
        String token = request.getHeader("token");
        String cookie = request.getHeader("Set-Cookie");

        Depart depart = departService.getDepartById(id);
        depart.setName(depart.getName() + ":" + port + ", token = " + token + ", cookie = " + cookie);
        return depart;
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departService.listDeparts();
    }
}
