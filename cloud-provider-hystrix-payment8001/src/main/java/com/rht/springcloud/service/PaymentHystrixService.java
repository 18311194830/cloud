package com.rht.springcloud.service;

public interface PaymentHystrixService {
    String Hystrix_OK(Integer id);

    String Hystrix_Timeout(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
