package com.rht.springcloud.service;

import com.rht.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int add(Payment payment);

    public Payment getPayment(@Param("id") Long id);


}
