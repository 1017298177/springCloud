package com.lcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: luochengmin
 * @Date: 2021/2/23 10:05
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain80 {
        public static void main(String[] args) {
            SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
