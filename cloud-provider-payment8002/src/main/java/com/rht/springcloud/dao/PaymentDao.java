package com.rht.springcloud.dao;

import com.rht.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaymentDao {
    public int add(Payment payment);

    public Payment getPayment(@Param("id") Long id);

}
