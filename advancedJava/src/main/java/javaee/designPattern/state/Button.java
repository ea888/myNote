package com.ecvlearning.javaee.designPattern.state;

public class Button {

    public void click(boolean checked){
        if(checked){
            System.out.println("Search on hao123.");
        }else {
            System.out.println("Search on google.");
        }
    }
}
