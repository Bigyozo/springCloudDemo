package dut.zfl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Zhangfanglong
 * @Date 2020/7/4 23:17
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain.class,args);
    }
}
