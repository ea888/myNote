package com.ecvlearning.javaee.designPattern.converter;

public class Client {
    public static void main(String[] args){
        VO vo = new VO();

        LegacyVO lv = Converter.getLegacyVo(vo);
        lv.getList();
        //....business logic
        //....
        //...


    }
}
