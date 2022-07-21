package com.example.Listener;

import com.example.Model.User;
import com.example.Service.RabbitUserReceiver;
import com.fasterxml.jackson.core.JsonStreamContext;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class UserListener {
//    @RabbitListener(queues = "Exchange1.queue")
    @Autowired
    private RabbitUserReceiver receiver;
    @RabbitListener(queues = "queue")
    @RabbitListener(queues = "queue1")
    @RabbitListener(queues = "queue2")
    @RabbitHandler
    public void receiveUser(String user){
        receiver.receiveUser(user);
        System.out.println("direct: ");
        System.out.println(user);
    }

    @RabbitListener(queues = "queue3")
    @RabbitListener(queues = "queue4")
    @RabbitHandler
    public void receiveUserFanout(String user){
        receiver.receiveUser(user);
        System.out.println("fanout: ");
        System.out.println(user);
    }

    @RabbitListener(queues = "queue5")
    @RabbitListener(queues = "queue6")
    @RabbitHandler
    public void receiveUserTopic(String user){
        receiver.receiveUser(user);
        System.out.println("Topic: ");
        System.out.println(user);
    }
}
