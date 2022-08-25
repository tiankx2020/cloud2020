package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entitys.CommonResult;
import com.atguigu.springcloud.entitys.Payment;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月24日 16:15
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
