package com.ecvlearning.javaee.designPattern.abstractFactory;

public class AbstractFactoryImpl implements AbsctractFactory{
    @Override
    public Suv produceSuv(String brand) {
        if("bmw".equalsIgnoreCase(brand)){
            return new BmwSuv();
        }else{
            return new AudiSuv();
        }
    }

    @Override
    public Sedan produceSedan(String brand) {
        if("bmw".equalsIgnoreCase(brand)){
            return new BmwSedan();
        }else{
            return new AudiSedan();
        }
    }
}
