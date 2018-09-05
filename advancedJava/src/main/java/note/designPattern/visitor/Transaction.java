package note.designPattern.visitor;

public interface Transaction {

    void accept(TradeStrategy ts);
}
