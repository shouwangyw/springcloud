package com.yw.springcloud.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yw.springcloud.example.po.Depart;
import com.yw.springcloud.example.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author yangwei
 */
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
//    private static final String API_URL = "http://msc-provider-depart/provider/depart/";
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @PostMapping("/save")
//    public boolean saveHandle(@RequestBody Depart depart) {
//        return restTemplate.postForObject(API_URL + "save", depart, Boolean.class);
//    }
//
//    @DeleteMapping("/del/{id}")
//    public void deleteHandle(@PathVariable("id") int id) {
//        restTemplate.delete(API_URL + "del/" + id);
//    }
//
//    @PutMapping("/update")
//    public void updateHandle(@RequestBody Depart depart) {
//        restTemplate.put(API_URL + "update", depart);
//    }
//
//    /**
//     * 指定该方法要使用服务降级
//     * 若当前处理器方法在运行过程中发生异常，无法给客户端正常响应时，就会调用 fallbackMethod 指定的方法
//     */
//    @HystrixCommand(fallbackMethod = "getHystrixHandle")
//    @GetMapping("/get/{id}")
//    public Depart getHandle(@PathVariable("id") int id) {
//        return restTemplate.getForObject(API_URL + "get/" + id, Depart.class);
//    }
//
//    /**
//     * 服务降级方法，即响应客户端的备选方案
//     */
//    private Depart getHystrixHandle(@PathVariable("id") int id) {
//        return new Depart()
//                .setId(id)
//                .setName("【Hystrix】No this depart -- 方法级别");
//    }
//
//    @GetMapping("/list")
//    public List<Depart> listHandle() {
//        return restTemplate.getForObject(API_URL + "list", List.class);
//    }

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

//    @HystrixCommand(fallbackMethod = "getHystrixHandle")
////            commandProperties = {@HystrixProperty(name = "hystrix.command.default.execution.isolation.strategy", value = "semaphore")})
//    @GetMapping("/get/{id}")
//    public Depart getHandle(@PathVariable("id") int id) {
//        return departService.getDepartById(id);
//    }

    @HystrixCommand(fallbackMethod = "getHystrixHandle")
    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id, HttpServletRequest request) {
        return departService.getDepartById(id);
    }

    private Depart getHystrixHandle(@PathVariable("id") int id, HttpServletRequest request) {
        // 指定存放到Redis中的key为"ip + 发生降级的方法名"
        String ip = request.getLocalAddr();
        String key = ip + "_getDepartById";
        // 异常发生后的报警
        queryCache(key);

        return new Depart()
                .setId(id)
                .setName("【Hystrix】No this depart -- 方法级别");
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    // 创建一个线程池，包含5个线程
    private ForkJoinPool pool = new ForkJoinPool(5);

    /**
     * 异常发生后的报警
     */
    private void queryCache(String key) {
        // 获取Redis操作对象
        BoundValueOperations<String, String> ops = redisTemplate.boundValueOps(key);
        String value = ops.get();
        if (value == null) {
            synchronized (this) {
                value = ops.get();
                if (value == null) {
                    // 使用线程池实现异步短信发送
                    sendFallbackMsg(key);
//                    value = "短信已发送";
//                    ops.set(value, 10, TimeUnit.SECONDS);
                    ops.set("短信已发送", 10, TimeUnit.SECONDS);
                }
            }
        }
    }

    /**
     * 使用线程池实现异步短信发送
     */
    private void sendFallbackMsg(String key) {
        pool.submit(() -> System.out.println("发送服务异常报警短信：" + key));
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departService.listDeparts();
    }
}