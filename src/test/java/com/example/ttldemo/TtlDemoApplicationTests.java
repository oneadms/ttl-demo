package com.example.ttldemo;

import javax.annotation.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TtlDemoApplicationTests {

  @Resource
  private RabbitTemplate rabbitTemplate;

  @Test
  void contextLoad() {
    Message message = MessageBuilder.withBody("hello".getBytes()).setExpiration("10000").build();
    rabbitTemplate.send(null,"hello_queue_direct",message);
  }
  @Test
  public void test01(){
    Message message = MessageBuilder.withBody("hello".getBytes()).build();

    rabbitTemplate.send("", RabbitConfig.TTL_QUEUE_NAME, message);
  }
  @Test
  public void test02(){

  }

}
