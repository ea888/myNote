package com.ecvlearning.javaee.designPattern.converter;

import java.util.ArrayList;
import java.util.List;

public class LegacyVO {
    List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
