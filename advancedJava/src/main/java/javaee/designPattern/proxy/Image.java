package com.ecvlearning.javaee.designPattern.proxy;

public class Image {
    private String name;
    private String path;
    private int size;

    private double code;

    public static Image getImage(){
        return new Image();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }
}
