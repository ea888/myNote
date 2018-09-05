package com.ecvlearning.javaee.designPattern.proxy;

public class Client {
    public static void main(String[] args){
        ImmutableMapProxy<String, ImmutableMapProxy> imp = new ImmutableMapProxy<>();

        Image image = Image.getImage();
        System.out.println(image.getName());
        System.out.println(image.getPath());

        ImageProxy ip = new ImageProxy();
        if(ip.getSize() > 100){
            ip.getName();
        }
    }
}
