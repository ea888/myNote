package com.chandler.exp.abstractFactory;

public class AudiSuv implements Suv {

	private String name = "Audi Q5";

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("I'm driving "+this.name);
	}
}
