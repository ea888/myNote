package com.chandler.exp.abstractFactory;

public class AudiSedan implements Sedan{
	private String name = "Audi A4";

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("I'm driving "+this.name);
	}
}
