package note.designPattern.fpVisitor;

public class Client {
    public static void main(String[] args) {
        Transaction et = new EquityTransaction();

        ((EquityTransaction)et).setAction("Buy");
        ((EquityTransaction)et).setPrice(100);
        ((EquityTransaction)et).setTicker("AAPL");

        TradeStrategy ts = new ArbitrageStrategy();
        et.accept(ts.makeArbitrageStrategy());
    }
}
