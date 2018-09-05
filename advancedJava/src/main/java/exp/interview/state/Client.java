package com.chandler.exp.interview.state;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Checkbox cb = new CheckboxConcrete();
		cb.toggle();
		cb.toggle();
	}

}
