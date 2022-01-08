package dut.zfl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author Zhangfl
 * @Date 2022/1/8
 * @Version 1.0
 * Description:
 **/
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListener {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者1，接受消息：" + message.getPayload() + "\t port:" + serverPort);
    }
}
