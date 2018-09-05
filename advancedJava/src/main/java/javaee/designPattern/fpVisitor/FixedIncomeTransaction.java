package com.ecvlearning.javaee.designPattern.fpVisitor;

import java.util.function.Consumer;

public class FixedIncomeTransaction implements Transaction {
    @Override
    public void accept(Consumer<Transaction> consumer) {
        consumer.accept(this);
    }
}
