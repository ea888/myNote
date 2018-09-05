package com.chandler.exp.abstractFactory;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractVehicleFactory bmw = AbstractVehicleFactory.getFactory("BMW");//new BMWFactory();
		AbstractVehicleFactory audi = AbstractVehicleFactory.getFactory("Audi");//new AudiFactory();
		
		bmw.produceSedan().drive();
		bmw.produceSuv().drive();
		
		audi.produceSedan().drive();
		audi.produceSuv().drive();
	}

}
