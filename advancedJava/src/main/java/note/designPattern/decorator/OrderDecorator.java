package note.designPattern.decorator;

public class OrderDecorator implements Order {
    protected Order order;
    public OrderDecorator(Order order){
        this.order = order;
    }

    public OrderDecorator(){
    }

    @Override
    public void prepare() {
        this.order.prepare();
    }

    @Override
    public void cost() {
        this.order.cost();
    }
}
