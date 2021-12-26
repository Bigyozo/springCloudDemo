package dut.zfl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Zhangfanglong
 * @Date 2020/7/2 14:52
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean("hasAnnotation")
    @LoadBalanced //使用MySelfRule创建的负载均衡器要添加注解，自定义负载均衡器不需要注解
    public RestTemplate loadBalanced() {
        return new RestTemplate();
    }

    @Bean
    @Primary
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
