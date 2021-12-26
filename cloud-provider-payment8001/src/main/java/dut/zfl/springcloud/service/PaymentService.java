package dut.zfl.springcloud.service;

import dut.zfl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Zhangfanglong
 * @Date 2020/7/1 10:25
 * @Version 1.0
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
