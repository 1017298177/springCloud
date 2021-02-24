package com.lcm.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: luochengmin
 * @Date: 2021/2/22 14:08
 */
@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }

}
