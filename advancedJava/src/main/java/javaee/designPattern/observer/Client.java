package com.ecvlearning.javaee.designPattern.observer;

public class Client {
    public static void main(String[] args){
        Teacher teacher = new Teacher();
        Student student = new Student("Jhon");

        Student student2 = new Student("Jhon");
        System.out.println(student == student2);
        System.out.println(student.equals(student2));

        Student student3 = new Student("Lucy");

        teacher.addStudent(student);
        teacher.addStudent(student3);
        teacher.gotcha();
        teacher.notifyStudent();
    }
}
