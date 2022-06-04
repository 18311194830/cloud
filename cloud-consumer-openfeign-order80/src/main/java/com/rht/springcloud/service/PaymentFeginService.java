package com.rht.springcloud.service;

import com.rht.springcloud.entities.CommonResult;
import com.rht.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeginService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> select(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/fegin/timeout")
    public String paymentFeginTimeOut();
}
