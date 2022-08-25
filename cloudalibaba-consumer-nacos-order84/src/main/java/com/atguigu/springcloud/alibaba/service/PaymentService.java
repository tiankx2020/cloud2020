package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entitys.CommonResult;
import com.atguigu.springcloud.entitys.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description: 消费端自定义服务降级
 * @author: scott
 * @date: 2022年08月24日 16:14
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
