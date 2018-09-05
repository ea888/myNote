package com.ecvlearning.javaee.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Teacher{
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void delStudent(Student student){
        this.students.remove(student);
    }

    public void notifyStudent(){
        for(Student s: this.students){
            s.hide();
        }
    }

    public void gotcha(){
        System.out.println("I keep an eye on you!");
    }
}
