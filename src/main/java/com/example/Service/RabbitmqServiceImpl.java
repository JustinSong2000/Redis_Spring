package com.example.Service;

import ch.qos.logback.classic.pattern.MessageConverter;
import com.alibaba.fastjson.JSON;
import com.example.Model.User;
import lombok.Data;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Data
@Service
public class RabbitmqServiceImpl implements RabbitmqSendService{
    private RabbitTemplate rabbit;
    @Autowired
    public RabbitmqServiceImpl(RabbitTemplate rabbit){
        this.rabbit = rabbit;
    }

    @Override
    public void sendUser(User u, String type) {
        switch (type){
            case "d":
                rabbit.convertAndSend("Exchange1", "key", JSON.toJSONString(u));
                break;
            case "b":
                rabbit.convertAndSend("Fanout1","", JSON.toJSONString(u));
                break;
            case "t":
                rabbit.convertAndSend("Topic1","key.6.ab.c", JSON.toJSONString(u));
                break;
            default:
                System.out.println("Do nothing");
                break;
        }
    }
}
