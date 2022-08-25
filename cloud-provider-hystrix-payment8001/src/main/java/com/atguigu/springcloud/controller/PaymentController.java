package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月15日 19:39
 */
@RestController
@Slf4j
public class PaymentController {


    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        String result = service.paymentInfoOk(id);
        log.info("result:"+result);
        return  result;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id){
        String result = service.paymentInfoException(id);
        log.info("result:"+result);
        System.out.println(result);
        return  result;
    }


    /**
     * 服务熔断
     * @param id
     * @return
     */
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = service.paymentCircuitBreak(id);
        log.info("****result: " + result);
        return result;
    }
}
