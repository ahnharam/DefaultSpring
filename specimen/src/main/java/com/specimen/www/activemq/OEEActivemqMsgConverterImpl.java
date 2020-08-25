package com.specimen.www.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class OEEActivemqMsgConverterImpl implements MessageConverter {
  private static final Logger logger = LoggerFactory.getLogger(OEEActivemqMsgConverterImpl.class);
  
  public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
    if (object instanceof OEEStateMqMessage) {
      //logger.info("toMessage1");
      OEEStateMqMessage msg = (OEEStateMqMessage)object;
      TextMessage sendmsg = session.createTextMessage(msg.toString());
      //logger.info(msg.toString());
      //logger.info("toMessage2");
      return (Message)sendmsg;
    } 
    //logger.info("toMessage3");
    return null;
  }
  
  public Object fromMessage(Message message) throws JMSException, MessageConversionException {
    if (!(message instanceof TextMessage)) {
      //logger.info("fromMessageError");
      throw new MessageConversionException("Messaeg isn't a OEEStateMqMessage");
    } 
    //logger.info("fromMessage1");
    TextMessage msg = (TextMessage)message;
    OEEStateMqMessage member = new OEEStateMqMessage();
    member.setMachineCode(msg.getText());
    //logger.info("fromMessage2");
    return member;
  }
}
