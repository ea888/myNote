package com.ecvlearning.javaee.designPattern.template;

public abstract class AbstractFileExporter implements FileExporter{
    public void readWordFile(String name){
        //read file
        System.out.println("Read MS word file: "+name);
    }
}
