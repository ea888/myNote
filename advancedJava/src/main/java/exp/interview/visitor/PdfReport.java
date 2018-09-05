package com.chandler.exp.interview.visitor;

public class PdfReport implements InspectionReport{

	@Override
	public void visit(House re) {
		// TODO Auto-generated method stub
		System.out.println("Produce "+ re.getName() +" report in pdf!");
//		List<Garden> gardens = re.getList();
//		gardens.forEach((item)->System.out.println("Produce "+ item.getName()+" report in pdf!"));
	}

	@Override
	public void visit(Condo re) {
		// TODO Auto-generated method stub
		System.out.println("Produce "+ re.getName() +" report in pdf!");
	}


}
