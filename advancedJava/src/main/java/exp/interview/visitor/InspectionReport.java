package com.chandler.exp.interview.visitor;

public interface InspectionReport {
	public void visit(House re);
	public void visit(Condo re);
}
