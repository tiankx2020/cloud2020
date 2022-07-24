package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entitys.CommonResult;
import com.atguigu.springcloud.entitys.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年04月16日 16:02
 */
@RestController()
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        return result>0?new CommonResult(200,"操作成功 port:"+serverPort,result):new CommonResult(444,"插入数据库失败",result);
    }


    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        return payment!=null?new CommonResult(200,"操作成功 port:"+serverPort,payment):new CommonResult(444,"插入数据库失败","result");
    }

}
