package com.chandler.exp.abstractFactory;

public class BMWFactory extends AbstractVehicleFactory{

	@Override
	public Sedan produceSedan() {
		// TODO Auto-generated method stub
		return new BMWSedan();
	}

	@Override
	public Suv produceSuv() {
		// TODO Auto-generated method stub
		return new BMWSuv();
	}

	
}
