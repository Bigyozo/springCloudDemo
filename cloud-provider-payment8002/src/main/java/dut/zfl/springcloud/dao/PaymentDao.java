package dut.zfl.springcloud.dao;

import dut.zfl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Zhangfanglong
 * @Date 2020/7/1 10:02
 * @Version 1.0
 */

//@Mapper
public interface PaymentDao {

    @Insert("insert into payment(serial) values(#{serial})")
    @Options(useGeneratedKeys = true)
    public int create(Payment payment);

    @Select("select * from payment where id = #{id}")
    public Payment getPaymentById(Long id);

    //public Payment getPaymentById(@Param("id") Long id);
}
