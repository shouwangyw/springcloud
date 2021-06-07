package com.yw.springcloud.example.component;

import com.yw.springcloud.example.service.DepartService;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangwei
 */
@Component
public class DepartFallbackFactory implements FallbackFactory<DepartService> {

    @Autowired
    private DepartFallback departFallback;

    @Override
    public DepartService create(Throwable throwable) {
        return departFallback;
    }
}
