package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月18日 17:04
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudalibabaConsumerNacosOrder83Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConsumerNacosOrder83Application.class, args);
        System.out.println("启动成功");
    }
}
