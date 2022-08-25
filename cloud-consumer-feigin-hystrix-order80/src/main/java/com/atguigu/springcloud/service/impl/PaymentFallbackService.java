package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @Description: 相当于远程调不通的话，自己进行服务降级
 * @author: scott
 * @date: 2022年08月16日 10:40
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String payment_ok(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
