package com.ecvlearning.javaee.designPattern.converter;

import java.util.HashSet;
import java.util.Set;

public class VO {
    private Set<String> set = new HashSet<>();

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }
}
