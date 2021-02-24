package com.lcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: luochengmin
 * @Date: 2021/2/23 19:07
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
        public static void main(String[] args) {
            SpringApplication.run(GatewayMain9527.class,args);
        }
}
