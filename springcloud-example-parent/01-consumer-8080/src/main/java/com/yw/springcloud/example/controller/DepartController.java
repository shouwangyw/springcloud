package com.yw.springcloud.example.controller;

import com.yw.springcloud.example.po.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author yangwei
 */
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    private final static String API_URL = "http://localhost:8090/provider/depart/";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        return restTemplate.postForObject(API_URL + "save", depart, Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") int id) {
        restTemplate.delete(API_URL + "del/" + id);
    }

    @PutMapping("/update")
    public void updateHandle(@RequestBody Depart depart) {
        restTemplate.put(API_URL + "update", depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return restTemplate.getForObject(API_URL + "get/" + id, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return restTemplate.getForObject(API_URL + "list", List.class);
    }
}
