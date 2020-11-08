///***********************************************************************************************************************
// * FileName - AmqpMsgConsumer.java
// *
// * (c) Disney. All rights reserved.
// *
// * $Author: ropeng $
// * $Revision: #1 $
// * $Change: 715510 $
// * $Date: Aug 5, 2015 $
// **********************************************************************************************************************/
//package om.disney.wdpro.otherservice.rabbitmq;
//
//import com.disney.wdpro.service.pmw.client.resource.NotifyResultResource;
//import com.rabbitmq.client.*;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
//@Component
//public class AmqpMsgConsumerStage<T extends NotifyResultResource> {
//
//    public static void main(String[] args) throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
////        factory.setHost("stage-rabbitmq.shdrapps.disney.com");
//        factory.setUsername("payment-middleware-service-stagea");
//        factory.setPassword("payment-middleware-service-stagea");
//        factory.setVirtualHost("/payment-middleware-stagea");
//        factory.setPort(5672);
//        factory.setAutomaticRecoveryEnabled(true);
//        factory.setNetworkRecoveryInterval(2);
//
////        Connection conn = factory.newConnection();
////        Connection conn = factory.newConnection(new Address[] {new Address("10.139.196.189"), new Address("10.139.196.106"), new Address("10.139.197.49")});
//        Connection conn = factory.newConnection(new Address[]{new Address("10.132.130.122"), new Address("10.132.130.198"), new Address("10.132.130.121")});
//        Channel channel = conn.createChannel();
//
//        channel.queueDeclare("payment_result", true, false, false, null);
//        System.out.println("begin consumer");
//
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//        boolean ack = true;
//        channel.basicConsume("payment_result", ack, consumer);
//        while (true) {
//            try {
//                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//                String message = new String(delivery.getBody());
//                System.out.println(message);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
