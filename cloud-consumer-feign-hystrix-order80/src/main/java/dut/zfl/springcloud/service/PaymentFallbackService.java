package dut.zfl.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author Zhangfl
 * @Date 2021/12/14
 * @Version 1.0
 * Description:
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---PaymentFallbackService paymentInfo_OK fall back";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---PaymentFallbackService paymentInfo_TimeOut fall back";
    }
}
