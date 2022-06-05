package com.rht.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    //规定该方法的正常限定时间为3秒
    @HystrixCommand(fallbackMethod = "Hystrix_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String Hystrix_Timeout(Integer id) {
        try {
            int timeNumber = 5;
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "Hystrix_Timeout,id:" + id;
    }

    public String Hystrix_TimeoutHandler(Integer id){
        return "线程池" + Thread.currentThread().getName() + "Hystrix_Timeout,id:" + id+"\t"+"o(<||>)o";
    }
}
