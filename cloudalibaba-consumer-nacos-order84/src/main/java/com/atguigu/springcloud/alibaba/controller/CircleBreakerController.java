package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entitys.CommonResult;
import com.atguigu.springcloud.entitys.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月24日 10:45
 */
@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    // fallback 管理运行异常
    // blockHandler  管理配置异常
    // fallback 和 blockHandler 两者都配置的话,blockHandler优先级较高
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback",
            // 表示忽视掉的异常，不走兜底
            exceptionsToIgnore = {IllegalArgumentException.class}
           )
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    // 本例市fallBack
    public CommonResult handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  " + e.getMessage(), payment);
    }

    // 本例是blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445, "blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage(), payment);
    }

    // 测试OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
