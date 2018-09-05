package com.ecvlearning.javaee.designPattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class FixedIncomeTransaction implements Transaction {
    private List<Gic> gics = new ArrayList<>();
    private List<Bond> bond = new ArrayList<>();
    private CaozongBit cb = null;

    public FixedIncomeTransaction(){

    }


    @Override
    public void accept(TradeStrategy ts) {
        gics.forEach(item->item.accept(ts));
        bond.forEach(item->item.accept(ts));
        cb.accept(ts);
    }

    public List<Gic> getGics() {
        return gics;
    }

    public void setGics(List<Gic> gics) {
        this.gics = gics;
    }

    public List<Bond> getBond() {
        return bond;
    }

    public void setBond(List<Bond> bond) {
        this.bond = bond;
    }

    public CaozongBit getCb() {
        return cb;
    }

    public void setCb(CaozongBit cb) {
        this.cb = cb;
    }
}
