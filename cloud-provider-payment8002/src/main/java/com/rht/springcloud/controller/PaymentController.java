package com.rht.springcloud.controller;

import com.rht.springcloud.entities.CommonResult;
import com.rht.springcloud.entities.Payment;
import com.rht.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("****结果"+result);
        if (result>0){
            return new CommonResult("200","插入成功,serverPort:"+serverPort,result);
        }else{
            return new CommonResult("444","插入失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult select(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        log.info("****结果"+payment);
        if (payment!= null){
            return new CommonResult("200","查询成功,serverPort:"+serverPort,payment);
        }else{
            return new CommonResult("444","没有对应记录");
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
