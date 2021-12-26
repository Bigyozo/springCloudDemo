package dut.zfl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Zhangfanglong
 * @Date 2020/7/5 13:58
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain.class,args);
    }
}
