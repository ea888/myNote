package com.chandler.exp.interview.visitor;

public class Garden extends House{

	private String name = "Garden";

	@Override
	public void accept(InspectionReport ir) {
		// TODO Auto-generated method stub
		ir.visit(this);
	}

	
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
}
