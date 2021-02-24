package com.lcm.controller;
import com.lcm.entity.CommonResult;
import com.lcm.entity.Payment;
import com.lcm.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object getDiscovery(){
        //查看当前Eureka中注册的服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******service:"+service);
        }
        //查看当前服务名称里的具体服务提供者信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
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
