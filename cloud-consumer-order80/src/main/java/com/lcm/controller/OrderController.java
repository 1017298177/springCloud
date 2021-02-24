package com.lcm.controller;


import com.lcm.entity.CommonResult;
import com.lcm.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    //用于发送请求的模板类
    @Autowired
    private RestTemplate restTemplate;

   //写操作
    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        //请求地址，传递的参数，返回值
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
     //读操作
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getCommonResult(@PathVariable("id") Long id){
        //请求地址，返回值
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getCommonResult2(@PathVariable("id") Long id){
        //请求地址，返回值
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }

}
