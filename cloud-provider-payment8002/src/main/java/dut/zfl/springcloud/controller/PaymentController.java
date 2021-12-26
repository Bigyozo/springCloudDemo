package dut.zfl.springcloud.controller;

import dut.zfl.springcloud.entities.CommonResult;
import dut.zfl.springcloud.entities.Payment;
import dut.zfl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    @PostMapping(value = "/payment/create",produces = "application/json;charset=utf-8")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,port="+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}",produces = "application/json;charset=utf-8")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查找结果" + payment);

        if (payment != null) {
            return new CommonResult(200, "查找数据库成功,port="+serverPort, payment);
        } else {
            return new CommonResult(444, "查询id=" + id + "结果为空", null);
        }
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
}
