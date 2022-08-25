package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月24日 10:44
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class CloudalibabaConsumerNacosOrder84Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConsumerNacosOrder84Application.class, args);
        System.out.println("启动成功");
    }

}
