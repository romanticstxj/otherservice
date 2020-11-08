package om.disney.wdpro.otherservice.rabbitmq;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class AmqpMsgQueueOperation {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("stage-rabbitmq.shdrapps.disney.com");
        factory.setUsername("payment-middleware-service-latesta");
        factory.setPassword("payment-middleware-service-latesta");
        factory.setVirtualHost("/payment-middleware-latesta");
        factory.setPort(5672);
        factory.setAutomaticRecoveryEnabled(true);
        factory.setNetworkRecoveryInterval(2);

//        Connection conn = factory.newConnection();
//        Connection conn = factory.newConnection(new Address[] {new Address("10.139.196.189"), new Address("10.139.197.49"), new Address("10.139.196.106")});
        Connection conn = factory.newConnection(new Address[]{new Address("10.132.128.179"), new Address("10.132.128.93"), new Address("10.132.128.94")});
        Channel channel = conn.createChannel();

        purgeQueue(channel, "payment_result_DEV");
        System.exit(0);
    }

    public static void deleteQueue(Channel channel, String queueName) throws IOException {
        channel.queueDelete(queueName);
    }

    public static void deleteQueueSafely(Channel channel, String queueName) throws IOException {
        channel.queueDelete(queueName, true, true);
    }

    public static void purgeQueue(Channel channel, String queueName) throws IOException {
        channel.queuePurge(queueName);
    }

    public static void deleteExchange(Channel channel, String exchangeName) throws IOException {
        channel.exchangeDelete(exchangeName);
    }

    public static void deleteExchangeSafely(Channel channel, String exchangeName) throws IOException {
        channel.exchangeDelete(exchangeName, true);
    }
}
