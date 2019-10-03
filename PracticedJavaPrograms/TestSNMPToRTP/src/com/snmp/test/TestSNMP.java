package com.snmp.test;

import java.io.IOException;

public class TestSNMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	      String str = "DTVMU:Testing netcool alerts to RTP netcool";
	      try {
	    	  System.out.println("Sending snmp trap with string:"+str);
			SendSNMPTrap.sendSNMPTrap(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
