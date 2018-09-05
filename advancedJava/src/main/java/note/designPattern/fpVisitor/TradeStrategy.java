package note.designPattern.fpVisitor;


import java.util.function.Consumer;

public interface TradeStrategy {
    void changeArbitrageStrategy(Consumer<Transaction> consumer);
    Consumer<Transaction> makeArbitrageStrategy();
}
