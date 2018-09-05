package com.ecvlearning.javaee.designPattern.converter;

import java.util.ArrayList;

public class Converter {
    public static LegacyVO getLegacyVo(VO vo){
        LegacyVO lv = new LegacyVO();
        lv.setList(new ArrayList<>(vo.getSet()));

        return lv;
    }
}
