package com.lcm.controller;

import com.lcm.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luochengmin
 * @Date: 2021/2/23 10:05
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_Handler")
public class OrderHystrixController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
//        int a = 1/0;
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_TimeOut(id);
    }

    /*
    全局降级
     */
    public String payment_Global_Handler(){
        return "程序异常，请稍后再试！";
    }
}
