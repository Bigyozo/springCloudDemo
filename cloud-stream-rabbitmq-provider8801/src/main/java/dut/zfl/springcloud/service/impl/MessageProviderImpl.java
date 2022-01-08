package dut.zfl.springcloud.service.impl;

import java.util.UUID;
import javax.annotation.Resource;

import dut.zfl.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Author Zhangfl
 * @Date 2022/1/8
 * @Version 1.0
 * Description:
 **/
@EnableBinding(Source.class)//定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        UUID uuid = UUID.randomUUID();
        output.send(MessageBuilder.withPayload(uuid).build());
        log.info("***sendMQ:" + uuid);
        return uuid.toString();
    }
}
