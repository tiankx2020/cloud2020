package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月15日 19:36
 */
@Service
public class PaymentService {

    public String paymentInfoOk(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_ok  id:"+id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoExceptionHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoException(Integer id){
        // try {
        //     TimeUnit.SECONDS.sleep(10);
        // }catch (Exception e){
        //     e.printStackTrace();
        // }
        int i = 10/0;
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_timeout id:"+id;
    }


    public String paymentInfoExceptionHandler(Integer id){
        return  "线程池:  " + Thread.currentThread().getName() + "  paymentInfoTimeOutHandler8001系统繁忙或者运行报错，请稍后再试,id:  " + id + "\t"
                + "o(╥﹏╥)o";
    }

    // ====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),/* 是否开启断路器*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")// 超时处理
    })
    public String paymentCircuitBreak(Integer id){
        if(id<0){
            throw  new RuntimeException("****id 不能为负数");
        }

        String serialNumber = IdUtil.simpleUUID();
        return  Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return Thread.currentThread().getName() + "\t" + "id 不能负数或超时或自身错误，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }
}
