package dut.zfl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author Zhangfanglong
 * @Date 2020/7/2 21:59
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7002.class,args);
    }
}
