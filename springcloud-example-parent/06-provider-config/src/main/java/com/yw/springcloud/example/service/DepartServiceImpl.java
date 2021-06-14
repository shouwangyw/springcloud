package com.yw.springcloud.example.service;

import com.yw.springcloud.example.po.Depart;
import com.yw.springcloud.example.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yangwei
 */
@Service
@RefreshScope
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository repository;
    @Value("${server.port}")
    private int port;
    @Value("${suffix}")
    private String suffix;

    @Override
    public boolean saveOne(Depart depart) {
        depart.setName(depart.getName() + suffix);
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
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (Exception ignore){ }
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
        return name + suffix;
    }
}
