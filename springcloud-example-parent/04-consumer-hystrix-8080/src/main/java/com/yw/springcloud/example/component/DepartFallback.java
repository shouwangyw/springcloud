package com.yw.springcloud.example.component;

import com.yw.springcloud.example.po.Depart;
import com.yw.springcloud.example.service.DepartService;

import java.util.List;

/**
 * @author yangwei
 * @date 2021-06-07 00:36
 */
public class DepartFallback implements DepartService {
    @Override
    public boolean saveOne(Depart depart) {
        System.out.println("执行 saveOne(Depart depart) 的服务降级处理方法");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("执行 deleteById(int id) 的服务降级处理方法");
        return false;
    }

    @Override
    public boolean updateOne(Depart depart) {
        System.out.println("执行 updateOne(Depart depart) 的服务降级处理方法");
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        System.out.println("执行 getDepartById(int id) 的服务降级处理方法");
        return new Depart().setId(id).setName("【Hystrix】No this depart -- 类级别");
    }

    @Override
    public List<Depart> listDeparts() {
        System.out.println("执行 listDeparts() 的服务降级处理方法");
        return null;
    }
}
