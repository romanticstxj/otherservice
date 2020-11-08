/***********************************************************************************************************************
 * FileName - AmqpMsgConsumer.java
 *
 * (c) Disney. All rights reserved.
 *
 * $Author: ropeng $
 * $Revision: #1 $
 * $Change: 715510 $
 * $Date: Aug 5, 2015 $
 **********************************************************************************************************************/
package om.disney.wdpro.otherservice.rabbitmq;

import com.disney.wdpro.service.pmw.client.resource.NotifyResultResource;
import com.rabbitmq.client.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class AmqpMsgConsumerLatest<T extends NotifyResultResource> {

    private static final String USER_NAME = "payment-middleware-service-latesta";
    private static final String PASSWORD = "payment-middleware-service-latesta";
    private static final String HOST = "/payment-middleware-latesta";
    private static final int PORT = 5672;

    private static final String EXCHANGE_NAME = "payment_result";
    private static final String EXCHANGE_TYPE = "x-combinePaymentQueryCriteria-message";
    private static final String QUEUE_NAME = "payment_result_DEV";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("stage-rabbitmq.shdrapps.disney.com");
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost(HOST);
        factory.setPort(PORT);
        factory.setAutomaticRecoveryEnabled(true);
        factory.setNetworkRecoveryInterval(2);

//        Connection conn = factory.newConnection();
//        Connection conn = factory.newConnection(new Address[] {new Address("10.139.196.189"), new Address("10.139.197.49"), new Address("10.139.196.106")});
        Connection conn = factory.newConnection(new Address[]{new Address("10.132.128.179"), new Address("10.132.128.93"), new Address("10.132.128.94")});
        Channel channel = conn.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, true);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println("begin consumer");

        boolean autoAck = true;
        channel.basicQos(64);
        channel.basicConsume(QUEUE_NAME, autoAck, "consumer1",
                new DefaultConsumer(channel){
                    @Override
                    public void handleDelivery(String consumerTag,
                                               Envelope envelope,
                                               AMQP.BasicProperties properties,
                                               byte[] body)
                            throws IOException
                    {
                        String routingKey = envelope.getRoutingKey();
                        String contentType = properties.getContentType();
                        long deliveryTag = envelope.getDeliveryTag();
                        //process message here
                        System.out.print(consumerTag + " consumes message: ");
                        String message = new String(body);
                        System.out.println(message);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        channel.basicAck(deliveryTag, false);
                    }
                });
    }
}
