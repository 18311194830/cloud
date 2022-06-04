package com.rht.springcloud.service.impl;

import com.rht.springcloud.dao.PaymentDao;
import com.rht.springcloud.entities.Payment;
import com.rht.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int add(Payment payment){
        return paymentDao.add(payment);
    }

    public Payment getPayment(@Param("id") Long id){
        return paymentDao.getPayment(id);
    }

}
