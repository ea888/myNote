package note.designPattern.decorator;

/**
 * This is the base class of the decorator chain, which does not contain other orders.
 * It means orginally, we can only order Drink, and we must order Drink.
 * With Decorator, we can order chicken and bread at RUNTIME.
 */
public class OrderDrink extends OrderDecorator {
    public OrderDrink(Order order) {
        super(order);
    }

    public OrderDrink() {
    }


    @Override
    public void prepare() {
        System.out.println("Order Drink!");
    }

    @Override
    public void cost() {
        System.out.println("$1!");
    }
}
