package dut.zfl.springcloud.controller;


import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;

import dut.zfl.springcloud.entities.CommonResult;
import dut.zfl.springcloud.entities.Payment;
import dut.zfl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zhangfanglong
 * @Date 2020/7/1 10:32
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create", produces = "application/json;charset=utf-8")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,port=" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}", produces = "application/json;charset=utf-8")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查找结果" + payment);

        if (payment != null) {
            return new CommonResult(200, "查找数据库成功,port=" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询id=" + id + "结果为空", null);
        }
    }

    @GetMapping(value = "/payment/discovery", produces = "application/json;charset=utf-8")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String temp : services
        ) {
            log.info("discover " + temp);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb", produces = "application/json;charset=utf-8")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout", produces = "application/json;charset=utf-8")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "paymentZipkin fall back";
    }
}
