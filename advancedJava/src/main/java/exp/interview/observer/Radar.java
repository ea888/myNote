package com.chandler.exp.interview.observer;

import java.util.Observable;
import java.util.Observer;

public class Radar implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println(((UFO)o).getShape()+" - "+arg);
	}
	
	public static void main(String args[]){
		UFO ufo = new UFO();
		ufo.addObserver(new Radar());//add observer to Obj being observed 
		ufo.changeShape("Square");
	}

}


class UFO extends Observable{
	String shape = "Round";
	
	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public void changeShape(String shape){
		this.shape = shape;
		this.setChanged();
//		this.notifyObservers();
		this.notifyObservers("Hahaha");//if we uncomment the above line, this one will not be called
	}
}