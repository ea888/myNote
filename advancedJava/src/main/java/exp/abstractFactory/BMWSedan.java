package com.chandler.exp.abstractFactory;

public class BMWSedan implements Sedan{

	private String name = "BMW 3";

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("I'm driving "+this.name);
	}
}
