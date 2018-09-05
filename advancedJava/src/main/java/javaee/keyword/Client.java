package com.ecvlearning.javaee.keyword;

public class Client {
    public static void main(String[] args){
        System.out.println(StaticSample.name);

        StaticSample ss = new StaticSample();
        System.out.println(ss.name);
        ss.name = "ss1";
        ss.instanceName = "akdjhasjd";

        StaticSample ss2 = new StaticSample();
        System.out.println(ss2.name);
        System.out.println(ss2.instanceName);
    }
}
