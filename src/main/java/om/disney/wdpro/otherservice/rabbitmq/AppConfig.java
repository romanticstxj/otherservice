package om.disney.wdpro.otherservice.rabbitmq;///***********************************************************************************************************************
// * FileName - AppConfig.java
// *
// * (c) Disney. All rights reserved.
// *
// * $Author: ropeng $
// * $Revision: #1 $
// * $Change: 715510 $
// * $Date: Aug 6, 2015 $
// **********************************************************************************************************************/
//package com.disney.wdpro.service.mockclient.mq;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.Binding.DestinationType;
//import org.springframework.amqp.core.CustomExchange;
//import org.springframework.amqp.core.Exchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.stereotype.Component;
//
//import javax.inject.Inject;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@Component
////@ImportResource(locations = "classpath:spring-rabbitmq.xml")
//public class AppConfig {
//
//    public static final Log LOGGER = LogFactory.getLog(AppConfig.class);
//
//    @Inject
//    private ConnectionFactory connectionFactory;
//
//    @Value("${rabbitmq.payment_result_queue}")
//    private String paymentResultQueueName;
//
//    @Value("${rabbitmq.exchange}")
//    private String paymentResultExchangeName;
//
//    @Value("${rabbitmq.payment_result_routing_key}")
//    private String paymentResultRoutingKey;
//
//    @Bean
//    public RabbitAdmin admin() {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        rabbitAdmin.afterPropertiesSet();
//        return rabbitAdmin;
//    }
//
//    @Bean
//    public Queue paymentConfirmQueue() {
//        return generateQueue(paymentResultQueueName);
//    }
//
//    private Queue generateQueue(String queueName){
//        boolean durable = true;
//        boolean autoDelete = false;
//        boolean exclusive = false;
//        Map<String, Object> queueArgs = new HashMap<>();
//        queueArgs.put("x-ha-policy", "all");
//        Queue paymentResultQueue = new Queue(queueName, durable, exclusive, autoDelete, queueArgs);
//        paymentResultQueue.setAdminsThatShouldDeclare(admin());
//
//        return paymentResultQueue;
//    }
//
//    @Bean
//    public Exchange exchange() {
//        boolean durable = true;
//        boolean autoDelete = false;
//        Map<String, Object> exchangeArgs = new HashMap<String, Object>();
//        exchangeArgs.put("x-delayed-type", "direct");
//        CustomExchange delayedMsgExchange = new CustomExchange(paymentResultExchangeName, "x-delayed-message", durable, autoDelete, exchangeArgs);
//        delayedMsgExchange.setAdminsThatShouldDeclare(admin());
//
//        return delayedMsgExchange;
//    }
//
//    @Bean
//    public Binding paymentBinding() {
//        Binding binding = new Binding(paymentConfirmQueue().getName(), DestinationType.QUEUE, exchange().getName(), paymentResultRoutingKey, null);
//        binding.setAdminsThatShouldDeclare(admin());
//        return binding;
//    }
//}
