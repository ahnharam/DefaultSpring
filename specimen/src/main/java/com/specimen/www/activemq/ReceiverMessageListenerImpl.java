package com.specimen.www.activemq;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class ReceiverMessageListenerImpl implements MessageListener {
  private static final Logger logger = LoggerFactory.getLogger(ReceiverMessageListenerImpl.class);
  
  @Resource
  private MessageConverter memberConverter;
  
  public void onMessage(Message message) {
    OEEStateMqMessage member = null;
    //logger.info("onMessage1");
    try {
      member = (OEEStateMqMessage)this.memberConverter.fromMessage(message);
      //logger.info("onMessage2");
      if (member != null) {
        System.out.println("member.toString(): " + member.toString());
        //logger.info("onMessage3");
      } 
    } catch (Exception e) {
      System.err.println(e);
    } 
  }
}
