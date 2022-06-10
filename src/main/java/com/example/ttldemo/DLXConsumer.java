package com.example.ttldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.logging.LoggerGroup;
import org.springframework.stereotype.Component;

/**
 * @author cnmgb
 * @version 1.0
 * @date 2022/6/10
 **/
@Component
public class DLXConsumer {

  Logger logger = LoggerFactory.getLogger(DLXConsumer.class.getName());
  @RabbitListener(queues = RabbitConfig.TTL_QUEUE_NAME)
  public void handleMsg(String msg ) {
    logger.info("handleMsg=>{}",msg);
  }
}
