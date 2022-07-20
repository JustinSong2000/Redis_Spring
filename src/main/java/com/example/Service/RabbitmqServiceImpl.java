package com.example.Service;

import ch.qos.logback.classic.pattern.MessageConverter;
import com.alibaba.fastjson.JSON;
import com.example.Model.User;
import lombok.Data;
import org.springframework.amqp.AmqpException;
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
    public void sendUser(User u) {
        rabbit.convertAndSend("Exchange1", "key1", JSON.toJSONString(u));
    }
}
