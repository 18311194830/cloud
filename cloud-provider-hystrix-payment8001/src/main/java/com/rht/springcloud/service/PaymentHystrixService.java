package com.rht.springcloud.service;

public interface PaymentHystrixService {
    String Hystrix_OK(Integer id);

    String Hystrix_Timeout(Integer id);
}
