package com.lcm.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

/**
 * @Author: luochengmin
 * @Date: 2021/2/23 15:50
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务宕机，请稍后再试！";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
         return "消费者80，系统繁忙请稍等10秒再试";
    }
}
