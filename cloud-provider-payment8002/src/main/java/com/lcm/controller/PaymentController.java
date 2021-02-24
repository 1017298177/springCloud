package com.lcm.controller;
import com.lcm.entity.CommonResult;
import com.lcm.entity.Payment;
import com.lcm.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    public String serverPort;


    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.insert(payment);
        if(result>0){
           return new CommonResult(200,"insert success,port:"+serverPort,null);
        }else {
            return new CommonResult(500,"false",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        if(payment!=null){
            return new CommonResult(200,"select success,port:"+serverPort,payment);
        }else {
            return new CommonResult(500,"false",null);
        }
    }
    @GetMapping(value = "/payment/feign/timeout")
    public String timeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


}
