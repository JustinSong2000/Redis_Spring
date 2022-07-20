package com.example.Service;

import com.example.Model.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public interface RabbitUserReceiver {
//    private RabbitTemplate rabbit;
//    private MessageConverter converter;
//
//    @Autowired
//    public RabbitUserReceiver(RabbitTemplate rabbitTemplate){
//        this.rabbit = rabbitTemplate;
//        this.converter = rabbitTemplate.getMessageConverter();
//    }
//
////    converter用于将消息进行格式的转换，如果消息不为空，就将消息进行转换
//    public User receiveUser(){
//        Message message = rabbit.receive("Exchange1");
//        return message != null ? (User) converter.fromMessage(message)
//                : null;
////        return (User) rabbit.receiveAndConvert("Exchange1.queue");
////        return rabbit.receiveAndConvert("Exchange1.queue", new ParameterizedTypeReference<User>(){});
//    }
    void receiveUser(String user);
}
