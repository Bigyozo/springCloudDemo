package dut.zfl.springcloud.controller;

import dut.zfl.springcloud.entities.CommonResult;
import dut.zfl.springcloud.entities.Payment;
import dut.zfl.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Zhang Fanglong
 * @Date 2020/7/6 16:18
 * @Version 1.0
 **/
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService feignService;

    @GetMapping(value = "/consumer/payment/get/{id}", produces = "application/json;charset=utf-8")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return feignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout", produces = "application/json;charset=utf-8")
    public String paymentFeignTimeout(){
        //超时服务
       return feignService.paymentFeignTimeout();
    }
}
