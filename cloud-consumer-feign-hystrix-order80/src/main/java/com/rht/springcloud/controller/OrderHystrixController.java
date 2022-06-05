package com.rht.springcloud.controller;

import com.rht.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String Hystrix_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.Hystrix_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String Hystrix_Timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.Hystrix_Timeout(id);
        return result;
    }
}
