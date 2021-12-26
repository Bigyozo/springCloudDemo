package dut.zfl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @Author Zhangfl
 * @Date 2021/12/14 16:09
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}
