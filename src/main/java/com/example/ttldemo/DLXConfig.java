package com.example.ttldemo;

import javax.management.MXBean;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/6/10
 **/
@Configuration
public class DLXConfig {

  public static final String DLX_QUEUE_NAME = "dlx_queue_name";
  public static final String DLX_EXCHANGE_NAME = "dlx_exchange_name";

  @Bean
  Queue dlxQueue() {
    return new Queue(DLX_QUEUE_NAME, true, false, false);
  }

  @Bean
  DirectExchange dlxExchange() {
    return new DirectExchange(DLX_EXCHANGE_NAME, true, true);
  }

  @Bean
  Binding dlxBinding() {
    return BindingBuilder.bind(dlxQueue()).to(dlxExchange()).with(DLX_QUEUE_NAME);
  }

 



}
