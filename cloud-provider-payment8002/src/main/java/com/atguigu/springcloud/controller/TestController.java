package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年04月16日 16:37
 */
@RestController("/test")
public class TestController {

    @GetMapping("/index")
    public String test(){
        return "hello";
    }
}
