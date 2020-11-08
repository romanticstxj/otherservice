/***********************************************************************************************************************
 * FileName - AmqpMsgProducer.java
 *
 * (c) Disney. All rights reserved.
 *
 * $Author: ropeng $
 * $Revision: #1 $
 * $Change: 715510 $
 * $Date: Jun 30, 2015 $
 **********************************************************************************************************************/
package om.disney.wdpro.otherservice.rabbitmq;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class AmqpMsgProducerProdB {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("stage-rabbitmq.shdrapps.disney.com");
        factory.setPort(5672);
        factory.setUsername("payment-middleware-service-proda");
        factory.setPassword("payment-middleware-service-proda");
        factory.setVirtualHost("/payment-middleware-proda");

//        Connection conn = factory.newConnection(new Address[] {new Address("10.139.196.189"), new Address("10.139.196.106"), new Address("10.139.197.96")});
//        Connection conn = factory.newConnection(new Address[] {new Address("10.132.130.122"), new Address("10.132.130.198"), new Address("10.132.130.121")});
        Connection conn = factory.newConnection(new Address[] {new Address("10.132.132.199"), new Address("10.132.133.172"), new Address("10.132.132.200")});
//        Connection conn = factory.newConnection();
        System.out.println("CONNECTION OK");
        Channel channel = conn.createChannel();
        channel.queueDeclare("payment_result_PRODB", true, false, false, null);

        System.out.println("begin producer");
//        IntStream.range(0, 65535).forEach(i -> {
//            try {
//                String message = "test" + i;
//                System.out.println(message);
////                channel.basicPublish("payment_exchange", "payment_result_rk3", null, (message + i).getBytes());
//                channel.basicPublish("payment_result", "payment_result_rk_4", null, (message).getBytes());
//                TimeUnit.SECONDS.sleep(5);
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

        channel.close();
        conn.close();
    }
}
