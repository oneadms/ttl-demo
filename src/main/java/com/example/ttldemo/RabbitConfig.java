package com.example.ttldemo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/6/10
 **/
@Configuration
public class RabbitConfig {

  public static final String TTL_QUEUE_NAME = "ttl_queue_name";

//  设置过期时间队列
  @Bean
  Queue ttlQueue() {
    Map<String, Object> args = new HashMap<>();
//    设置消息过期时间
    args.put("x-message-ttl", 10000);
//    设置死信交换机
    args.put("x-dead-letter-exchange", DLXConfig.DLX_EXCHANGE_NAME);

    args.put("x-dead-letter-routing-key", DLXConfig.DLX_QUEUE_NAME);
    return new Queue(TTL_QUEUE_NAME, true, false
        , false,args);
  }
}
