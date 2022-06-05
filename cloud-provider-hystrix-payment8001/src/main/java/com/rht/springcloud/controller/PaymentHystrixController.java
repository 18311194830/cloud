package com.rht.springcloud.controller;

import com.rht.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String Hystrix_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.Hystrix_OK(id);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String Hystrix_Timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.Hystrix_Timeout(id);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentCircuitBreaker(id);
        log.info("+++++result:"+result);
        return result;
    }
}
