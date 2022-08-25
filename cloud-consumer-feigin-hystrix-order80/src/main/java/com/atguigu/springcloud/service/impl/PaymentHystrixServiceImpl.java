package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月16日 10:40
 */
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String payment_ok(Integer id) {
        return  "自定义1";
    }

    @Override
    public String payment_timeout(Integer id) {
        return  "自定义2";
    }
}
