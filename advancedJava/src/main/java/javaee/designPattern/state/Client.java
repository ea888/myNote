package com.ecvlearning.javaee.designPattern.state;

public class Client {
    public static void main(String[] args){
        System.out.println("Click on checkbox!");
        Checkbox cb = new Checkbox();


        Button b = new Button();
        b.click(cb.isChecked());
        cb.click();
        cb.click();
        b.click(cb.isChecked());
        cb.click();
        b.click(cb.isChecked());
        cb.click();
        b.click(cb.isChecked());
        cb.click();
        b.click(cb.isChecked());
        cb.click();
        cb.click();
        b.click(cb.isChecked());
        cb.click();
        cb.click();
        b.click(cb.isChecked());
        cb.click();
    }
}
