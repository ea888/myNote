package com.chandler.exp.interview.visitor;

import java.util.ArrayList;
import java.util.List;

public class House implements RealEstate{
	private List<Garden> list = new ArrayList<>();
	
	private String name = "House";

	@Override
	public void accept(InspectionReport ir) {
		// TODO Auto-generated method stub
		ir.visit(this);
		//call accept for each sub elements
		this.list.forEach((item)->item.accept(ir));
	}

	
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
	public List<Garden> getList() {
		return list;
	}

	public void setList(List<Garden> list) {
		this.list = list;
	}


}
