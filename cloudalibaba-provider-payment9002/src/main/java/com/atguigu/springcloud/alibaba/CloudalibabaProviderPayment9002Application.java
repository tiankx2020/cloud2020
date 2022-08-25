package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月18日 16:44
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudalibabaProviderPayment9002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaProviderPayment9002Application.class, args);
        System.out.println("启动成功");
    }

}
