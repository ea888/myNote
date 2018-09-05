package com.chandler.exp.interview.visitor;

public class Condo implements RealEstate{
	private String name = "Condo";

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
