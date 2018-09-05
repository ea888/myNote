package com.chandler.exp.interview.visitor;

/**
 * very similar to bridge, but emphasize runtime logic
 * @author demon
 *
 */
public class Client {

	public static void main(String args[]){
		//logic with visit method, has nothing to do with structure
		InspectionReport pdf = new PdfReport();
		InspectionReport word = new WordReport();
		
		//structure accept logic
		//structure deal with their own problem and call visit, refer to house implementation
		Condo condo = new Condo();
		House house = new House();
		Garden garden1 = new Garden();
		Garden garden2 = new Garden();
		garden1.setName("Flower Garden");
		garden2.setName("Grass Garden");
		house.getList().add(garden1);
		house.getList().add(garden2);
		
		condo.accept(pdf);
		condo.accept(word);
		
		house.accept(pdf);
		house.accept(word);
	}
}
