package note.designPattern.decorator;

public class Client {
    public static void main(String[] args) {
        Order order = new OrderBreadImpl(new OrderChicken(new OrderDrink()));
        order.prepare();
        order.cost();
    }

}
