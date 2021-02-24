package com.lcm.service;

import com.lcm.entity.CommonResult;
import com.lcm.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: luochengmin
 * @Date: 2021/2/22 11:24
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id);
    @GetMapping(value = "/payment/feign/timeout")
    public String timeout();
}
