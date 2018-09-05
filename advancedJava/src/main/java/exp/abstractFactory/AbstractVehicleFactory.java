package com.chandler.exp.abstractFactory;

public abstract class AbstractVehicleFactory {
	public static AbstractVehicleFactory getFactory(String brand){
		if("BMW".equals(brand))
			return new BMWFactory();
		else if("Audi".equals(brand))
			return new AudiFactory();
		else
			return null;
	}
	
	public abstract Sedan produceSedan();
	public abstract Suv produceSuv();
}
