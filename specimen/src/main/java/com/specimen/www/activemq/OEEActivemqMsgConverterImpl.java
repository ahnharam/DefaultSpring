package com.specimen.www.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class OEEActivemqMsgConverterImpl implements MessageConverter {
	  private static final Logger logger = LoggerFactory.getLogger(OEEActivemqMsgConverterImpl.class);
	  @Value("#{props['test.number']}")
	  private String test;
	  
	  public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		  if (object instanceof OEEStateMqMessage) {
			  //logger.debug("toMessage1");
			  OEEStateMqMessage msg = (OEEStateMqMessage)object;
			  TextMessage sendmsg = session.createTextMessage(msg.toString());
			  //logger.debug(msg.toString());
			  logger.debug("toMessage2");
			  return (Message)sendmsg;
		  }  
		  logger.debug("toMessage3");
		  return null;
	  }
	  
	  public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		  	//logger.debug("fromMessage start");
		    if (!(message instanceof TextMessage)) {
		    	logger.debug("fromMessageError");
		    	throw new MessageConversionException("Messaeg isn't a OEEStateMqMessage");
		    } 
		    TextMessage msg = (TextMessage)message;
		    OEEStateMqMessage member = new OEEStateMqMessage();
		    member.setMachineCode(msg.getText());
		    logger.debug("fromMessage end");
		    logger.debug(test);
		    return member;
	  }
}
