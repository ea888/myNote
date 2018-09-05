package com.ecvlearning.javaee.designPattern.observer;


public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void hide(){
        System.out.println("Eat the slip!");
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Student){
            if(this.name.equals(((Student)o).name)){
                return true;
            }else{
                return false;
            }
        }else
            return super.equals(o);
    }
}
