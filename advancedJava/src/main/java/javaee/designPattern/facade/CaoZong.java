package com.ecvlearning.javaee.designPattern.facade;

public class CaoZong {
    public static void main(String[] args){
        QiuFacade qiu = new QiuFacade();
        qiu.goodMorning();

        //work 8 hours

        qiu.bye();
    }
}
