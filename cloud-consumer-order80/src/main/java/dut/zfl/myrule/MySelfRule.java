package dut.zfl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Zhangfanglong
 * @Date 2020/7/5 16:39
 * @Version 1.0
 */
//IRule不能配置在@ComponentScan(@SpringbootApplication)作用范围下
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
        return new RandomRule();//定义为随机
    }
}
