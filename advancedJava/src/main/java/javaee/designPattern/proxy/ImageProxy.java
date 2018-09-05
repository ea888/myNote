package com.ecvlearning.javaee.designPattern.proxy;

public class ImageProxy {
    Image image = Image.getImage();

    public String getName(){
        return this.image.getName();
    }

    public int getSize(){
        return this.image.getSize();
    }
}
