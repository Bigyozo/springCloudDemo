package dut.zfl.springcloud.service;

import dut.zfl.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Zhang Fanglong
 * @Date 2020/7/6 16:11
 * @Version 1.0
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}", produces = "application/json;charset=utf-8")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout", produces = "application/json;charset=utf-8")
    public String paymentFeignTimeout();
}
