package com.lcm.controller;

import com.lcm.entity.CommonResult;
import com.lcm.entity.Payment;
import com.lcm.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luochengmin
 * @Date: 2021/2/22 11:32
 */
@RestController
public class PaymentFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        return paymentFeignService.create(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String timeout(){
        return paymentFeignService.timeout();
    }
}
