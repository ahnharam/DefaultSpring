package com.specimen.www.activemq;

public class OEEStateMqMessage {
	  String MachineCode;
	  
	  String State;
	  
	  public String getMachineCode() {
	    return this.MachineCode;
	  }
	  
	  public void setMachineCode(String machineCode) {
	    this.MachineCode = machineCode;
	  }
	  
	  public String getState() {
	    return this.State;
	  }
	  
	  public void setState(String state) {
	    this.State = state;
	  }
	  
	  public String toString() {
	    return "MachineCode = " + this.MachineCode;
	  }
	}
