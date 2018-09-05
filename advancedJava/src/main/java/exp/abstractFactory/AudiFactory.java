package com.chandler.exp.abstractFactory;

public class AudiFactory extends AbstractVehicleFactory{

	@Override
	public Sedan produceSedan() {
		// TODO Auto-generated method stub
		return new AudiSedan();
	}

	@Override
	public Suv produceSuv() {
		// TODO Auto-generated method stub
		return new AudiSuv();
	}

}
