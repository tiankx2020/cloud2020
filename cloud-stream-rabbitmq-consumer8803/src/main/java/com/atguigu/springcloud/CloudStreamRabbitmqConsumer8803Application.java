package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月18日 13:52
 */
@SpringBootApplication
public class CloudStreamRabbitmqConsumer8803Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqConsumer8803Application.class, args);
        System.out.println("启动成功");
    }
}
