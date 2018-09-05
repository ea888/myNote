package com.chandler.exp.decorator;

public class Outlet implements PowerOutlet{

	@Override
	public void supply() {
		// TODO Auto-generated method stub
		System.out.println("I have 220V 2000W power!");
	}

	
}
