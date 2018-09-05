package exp;

import java.util.function.Consumer;

public class AdvancedConsumer {

	public void shout(String msg){
		System.out.println(msg);
	}
	
	public void exec(Consumer<String> c, String t){
		c.accept(t);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdvancedConsumer ac = new AdvancedConsumer();
		ac.exec((s)->ac.shout(s), "hahaha!");
	}

}
