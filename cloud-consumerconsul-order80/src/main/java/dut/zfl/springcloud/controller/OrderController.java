package dut.zfl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Zhangfanglong
 * @Date 2020/7/2 14:47
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/payment/consul", produces = "application/json;charset=utf-8")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
