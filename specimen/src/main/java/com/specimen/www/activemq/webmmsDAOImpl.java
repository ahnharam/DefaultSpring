package com.specimen.www.activemq;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jms.core.JmsTemplate;

public class webmmsDAOImpl implements webmmsDAO {
  @Resource(name = "OEEproducerJmsTemplate")
  JmsTemplate OEEmqProducer;
  
  public void updateOIMachineState(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    OEEStateMqMessage msg = new OEEStateMqMessage();
    msg.setMachineCode("TESTCODE");
    this.OEEmqProducer.convertAndSend("test", msg);
    response.getWriter().print("done");
  }
}
