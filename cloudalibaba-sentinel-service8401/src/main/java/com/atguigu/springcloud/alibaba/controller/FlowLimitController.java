package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Warmup配置
 *
 * @author lixiaolong
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        // 测试阈值类型：线程数
        // try {
        //     TimeUnit.MILLISECONDS.sleep(8000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        log.info("testC 异常比例");
        int age = 10 / 0;
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10 / 0;
        return "------testE 测试异常数";
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    // 资源名称
    @SentinelResource(value = "hotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String dealTestHotKey(String p1, String p2, BlockException exception) {
        //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
        return "------deal_testHotKey,o(╥﹏╥)o";
    }

    @GetMapping("/testHotKey2")
    // 资源名称
    @SentinelResource(value = "hotKey", blockHandler = "dealTestHotKey2")
    public String testHotKey2(@RequestParam(value = "p3", required = false) String p3,
                             @RequestParam(value = "p4", required = false) String p4) {
        return "------testHotKey2";
    }

    public String dealTestHotKey2(String p3, String p4, BlockException exception) {
        //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
        return "------deal_testHotKey2,o(╥﹏╥)o";
    }

}
