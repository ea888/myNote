package com.chandler.exp.interview.visitor;

public class WordReport implements InspectionReport{

	@Override
	public void visit(House re) {
		// TODO Auto-generated method stub
		System.out.println("Produce "+ re.getName() +" report in word!");
//		List<Garden> gardens = re.getList();
//		gardens.forEach((item)->System.out.println("Produce "+ item.getName() +" report in word!"));
	}

	@Override
	public void visit(Condo re) {
		// TODO Auto-generated method stub
		System.out.println("Produce "+ re.getName() +" report in word!");
	}

}
