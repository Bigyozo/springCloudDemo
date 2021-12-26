package dut.zfl.springcloud.service.impl;

import dut.zfl.springcloud.dao.PaymentDao;
import dut.zfl.springcloud.entities.Payment;
import dut.zfl.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Author Zhangfanglong
 * @Date 2020/7/1 10:26
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }
}
