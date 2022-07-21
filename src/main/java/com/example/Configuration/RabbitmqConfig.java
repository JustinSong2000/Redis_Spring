package com.example.Configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class RabbitmqConfig {
    public static final String QUEUE = "queue";
    public static final String QUEUE1 = "queue1";
    public static final String QUEUE2 = "queue2";
    public static final String QUEUE3 = "queue3";
    public static final String QUEUE4 = "queue4";
    public static final String QUEUE5 = "queue5";
    public static final String QUEUE6 = "queue6";
    public static final String EXCHANGE1 = "Exchange1";
    public static final String EXCHANGE2 = "Fanout1";
    public static final String EXCHANGE3 = "Topic1";

//    创建交换机
    @Bean(EXCHANGE1)
    public Exchange EXCHANGE1(){
        return ExchangeBuilder.directExchange(EXCHANGE1).durable(true).alternate("").build();
    }

    @Bean(EXCHANGE2)
    public Exchange EXCHANGE2(){
        return ExchangeBuilder.fanoutExchange(EXCHANGE2).durable(true).build();
    }

    @Bean(EXCHANGE3)
    public Exchange EXCHANGE3(){
        return ExchangeBuilder.topicExchange(EXCHANGE3).durable(true).build();
    }

//    创建队列
    @Bean("queue")
    public Queue QUEUE() {
        return new Queue(QUEUE);
    }

    @Bean("queue1")
    public Queue QUEUE1() {
        return new Queue(QUEUE1);
    }

    @Bean("queue2")
    public Queue QUEUE2() {
        return new Queue(QUEUE2);
    }

    @Bean("queue3")
    public Queue QUEUE3() {
        return new Queue(QUEUE3);
    }

    @Bean("queue4")
    public Queue QUEUE4() {
        return new Queue(QUEUE4);
    }

    @Bean("queue5")
    public Queue QUEUE5() {
        return new Queue(QUEUE5);
    }

    @Bean("queue6")
    public Queue QUEUE6() {
        return new Queue(QUEUE6);
    }

//    创建连接
    @Bean
    public Binding BINDING_QUEUE(@Qualifier(QUEUE) Queue queue, //从spring容器中取出队列和交换机
                                            @Qualifier(EXCHANGE1) Exchange Exchange1) { //使用名称注入Bean用@Qualifier注解
        return BindingBuilder.bind(queue).to(Exchange1).with("key").noargs(); //with后面的参数为routingKey
    }
    @Bean
    public Binding BINDING_QUEUE1(@Qualifier(QUEUE1) Queue queue1, //从spring容器中取出队列和交换机
                                            @Qualifier(EXCHANGE1) Exchange Exchange1) { //使用名称注入Bean用@Qualifier注解
        return BindingBuilder.bind(queue1).to(Exchange1).with("key1").noargs(); //with后面的参数为routingKey
    }
    @Bean
    public Binding BINDING_QUEUE2(@Qualifier(QUEUE2) Queue queue2, //从spring容器中取出队列和交换机
                                  @Qualifier(EXCHANGE1) Exchange Exchange1) { //使用名称注入Bean用@Qualifier注解
        return BindingBuilder.bind(queue2).to(Exchange1).with("key2").noargs(); //with后面的参数为routingKey
    }
    @Bean
    public Binding BINDING_QUEUE3(@Qualifier(QUEUE3) Queue queue3, //从spring容器中取出队列和交换机
                                  @Qualifier(EXCHANGE2) Exchange Fanout1) { //使用名称注入Bean用@Qualifier注解
        return BindingBuilder.bind(queue3).to(Fanout1).with("key3").noargs(); //with后面的参数为routingKey
    }
    @Bean
    public Binding BINDING_QUEUE4(@Qualifier(QUEUE4) Queue queue4, //从spring容器中取出队列和交换机
                                  @Qualifier(EXCHANGE2) Exchange Fanout1) { //使用名称注入Bean用@Qualifier注解
        return BindingBuilder.bind(queue4).to(Fanout1).with("key4").noargs(); //with后面的参数为routingKey
    }
    @Bean
    public Binding BINDING_QUEUE5(@Qualifier(QUEUE5) Queue queue5, //从spring容器中取出队列和交换机
                                  @Qualifier(EXCHANGE3) Exchange Topic1) { //使用名称注入Bean用@Qualifier注解
        return BindingBuilder.bind(queue5).to(Topic1).with("key.5.*").noargs(); //with后面的参数为routingKey
    }
    @Bean
    public Binding BINDING_QUEUE6(@Qualifier(QUEUE6) Queue queue6, //从spring容器中取出队列和交换机
                                  @Qualifier(EXCHANGE3) Exchange Topic1) { //使用名称注入Bean用@Qualifier注解
        return BindingBuilder.bind(queue6).to(Topic1).with("#.key.6.#").noargs(); //with后面的参数为routingKey
    }
}
