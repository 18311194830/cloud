package com.rht.springcloud.controller;

import com.rht.springcloud.entities.CommonResult;
import com.rht.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/add")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @PostMapping("/consumer/payment/entity/add")
    public CommonResult<Payment> create2(@RequestBody Payment payment) {
        return restTemplate.postForEntity(PAYMENT_URL + "/payment/add", payment, CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else {
            return new CommonResult<>("444","操作失败");
        }
    }
}
