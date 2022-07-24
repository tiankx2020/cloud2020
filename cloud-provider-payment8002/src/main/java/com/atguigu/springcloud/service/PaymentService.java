package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entitys.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年04月16日 15:52
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
