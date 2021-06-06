package com.yw.springcloud.example.service;

import com.yw.springcloud.example.po.Depart;
import com.yw.springcloud.example.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangwei
 */
@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository repository;
    // 读取配置文件中的属性值：服务端口号
    @Value("${server.port}")
    private int port;

    @Override
    public boolean saveOne(Depart depart) {
        // repository.save()可以完成插入和修改
        // 若操作对象的id==null，则执行插入；若id!=null，则执行修改；
        // 若操作对象的id!=null但不存在，则执行插入，但插入后该对象id并非是指定的id，而是由DB自动生成
        return repository.save(depart) != null;
    }

    @Override
    public boolean deleteById(int id) {
        // repository.existsById()中指定的id若不存在，则会抛出异常，因此这里要先判断是否存在
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateOne(Depart depart) {
        return repository.save(depart) != null;
    }

    @Override
    public Depart getDepartById(int id) {
        // repository.getOne()中指定的id若不存在，则会抛出异常，因此这里要先判断是否存在
        if (repository.existsById(id)) {
            Depart depart = repository.getOne(id);
            depart.setName(rename(depart.getName()));
            return depart;
        }
        return new Depart().setName(port + " No this depart");
    }

    @Override
    public List<Depart> listDeparts() {
        List<Depart> departs = repository.findAll();
        departs.forEach(v -> v.setName(rename(v.getName())));
        return departs;
    }

    private String rename(String name) {
        return name + " : " + port;
    }
}
