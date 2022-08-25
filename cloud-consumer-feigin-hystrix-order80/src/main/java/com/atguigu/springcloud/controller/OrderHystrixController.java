package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月16日 7:56
 */
@RestController
@Slf4j
// @DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")// hystrix 全局fallback方法
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService service;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    String payment_ok(@PathVariable("id") Integer id) {
        String result = service.payment_ok(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    // @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    // })
    // @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        // 全局异常处理
        int i = 10/0;
        String result = service.payment_timeout(id);
        return result;
    }

    /**
     * 超时访问，设置自身调用超时的峰值，峰值内正常运行，超过了峰值需要服务降级 自动调用fallbackMethod 指定的方法
     * <br/>
     * 超时异常或者运行异常 都会进行服务降级
     *
     * @param id
     * @return
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
