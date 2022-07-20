package com.example.Listener;

import com.example.Model.User;
import com.example.Service.RabbitUserReceiver;
import com.fasterxml.jackson.core.JsonStreamContext;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue")
public class UserListener {
//    @RabbitListener(queues = "Exchange1.queue")
    @Autowired
    private RabbitUserReceiver receiver;
    @RabbitHandler
    public void receiveUser(String user){
        receiver.receiveUser(user);
        System.out.println(user);
    }
}
