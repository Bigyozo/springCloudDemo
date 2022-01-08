package dut.zfl.springcloud.controller;

import javax.annotation.Resource;

import dut.zfl.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zhangfl
 * @Date 2022/1/8
 * @Version 1.0
 * Description:
 **/
@RestController
public class SendMsgController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMsg")
    public String sendMessage(){
        return messageProvider.send();
    }
}
