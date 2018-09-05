package com.chandler.exp.interview.state;

public class CheckboxConcrete implements Checkbox{

	private enum State{
		CHECKED, UNCHECKED
	}
	
	private State currentState = State.UNCHECKED;
	
	@Override
	public void toggle() {
		// TODO Auto-generated method stub
		if(this.currentState == State.CHECKED){
			System.out.println("Uncheck chekbox!");
			this.currentState = State.UNCHECKED;
		}else{
			System.out.println("Check chekbox!");
			this.currentState = State.CHECKED;
		}
	}

}
