package com.lcm.controller;


import com.lcm.entity.CommonResult;
import com.lcm.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL="http://cloud-provider-payment";
    //用于发送请求的模板类
    @Autowired
    private RestTemplate restTemplate;

     //读操作
    @GetMapping("/consumer/payment/zk")
    public String getCommonResult(){
        //请求地址，返回值
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }

}
