package com.snmp.test;

import java.io.IOException;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TimeTicks;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SendSNMPTrap {

//public static void main(String[] args) throws Exception {
	public static void sendSNMPTrap(String str) throws IOException {
// Create PDU           
PDU trap = new PDU();
trap.setType(PDU.TRAP);

  OID oid = new OID("1.3.6.1.4.1.193.9999.101");
  trap.add(new VariableBinding(SnmpConstants.snmpTrapOID, oid));
  trap.add(new VariableBinding(SnmpConstants.sysUpTime, new TimeTicks(5000))); 
  // put your uptime here
  trap.add(new VariableBinding(SnmpConstants.sysDescr, new OctetString("6"))); 

  //Add Payload
  Variable var = new OctetString(str);          
  trap.add(new VariableBinding(oid, var));          

  // Specify receiver
  Address targetaddress = new UdpAddress("10.85.217.30/7762");
  CommunityTarget target = new CommunityTarget();
  target.setCommunity(new OctetString("public"));
  target.setVersion(SnmpConstants.version2c);
  target.setAddress(targetaddress);
  
  System.out.println("trap:"+trap.toString());
  System.out.println("target:"+target.toString());

  System.out.println("sending trap");
  // Send
  Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
  snmp.send(trap, target, null, null); 
  System.out.println("sent trap");
}
}
