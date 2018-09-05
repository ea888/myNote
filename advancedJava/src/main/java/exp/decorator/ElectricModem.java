package com.chandler.exp.decorator;

public class ElectricModem extends Outlet{

	
	public void supply() {
		// TODO Auto-generated method stub
		super.supply();
		System.out.println("I'm a modem, I connet to internet via electricity wires!");
	}
}
