package com.rht.springcloud.controller;

import com.rht.springcloud.entities.CommonResult;
import com.rht.springcloud.entities.Payment;
import com.rht.springcloud.service.PaymentFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeginController {
    @Resource
    private PaymentFeginService paymentFeginService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> select(@PathVariable("id") Long id){
        return paymentFeginService.select(id);
    }

    @GetMapping(value = "/consumer/payment/fegin/timeout")
    public String paymentFeginTimeOut(){
        //openfegin-ribbon一般默认等待1秒钟
        return paymentFeginService.paymentFeginTimeOut();
    }

}
