package dut.zfl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Zhangfl
 * @Date 2022/1/3
 * @Version 1.0
 * Description:
 **/
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigMain3366.class, args);
    }
}
