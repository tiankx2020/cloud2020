package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月24日 10:36
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudalibabaProviderPayment9004Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaProviderPayment9004Application.class, args);
        System.out.println("启动成功");
    }

}
