package com.rht.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String Hystrix_OK(Integer id) {
        return "--------PaymentFallbackService fall back-Hystrix_OK";
    }

    @Override
    public String Hystrix_Timeout(Integer id) {
        return "--------PaymentFallbackService fall back-Hystrix_Timeout";
    }
}
