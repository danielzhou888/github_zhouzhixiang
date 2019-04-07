package com.zhouzhixiang.rabbitmq.chapter1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: scmd-knb-common
 * @description: 生产者
 * @author: zhouzhixiang
 * @create: 2019-03-28 19:59
 */
public class SendRabbitMQ {

    private final static String QUEUE_NAME = "Hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // connection是socket连接的抽象，并且为我们管理协议版本协商（protocol version negotiation），
        // 认证（authentication ）等等事情。这里我们要连接的消息代理在远程，因此我们将host设为“远程ip”。
        // 如果我们想连接其他机器上的代理，只需要将这里改为特定的主机名或IP地址。
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.100.1.46");
        factory.setPort(5672);
        factory.setUsername("zhouzhixiang");
        factory.setPassword("zhouzhixiang");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 接下来，我们创建一个channel，绝大部分API方法需要通过调用它来完成。
        // 发送之前，我们必须声明消息要发往哪个队列，然后我们可以向队列发一条消息：
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hi！Java猿社区";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Send '" + message + "'");
        channel.close();
        connection.close();
    }
}
