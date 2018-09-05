package com.chandler.exp.decorator;

public class Client {

	public static void main(String args[]){
		Computer c = new Computer();
		//electric modem is the decorator
		c.connect(new ElectricModem());
	}
}
