package com.rht.springcloud.service.impl;

import com.rht.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String Hystrix_OK(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "Hystrix_OK,id:" + id;
    }

    @Override
    public String Hystrix_Timeout(Integer id) {
        try {
            int timeNumber = 3;
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "Hystrix_Timeout,id:" + id;
    }
}
