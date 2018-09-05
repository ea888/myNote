package com.chandler.exp.interview;

public class CycleDetection {	
	
	Point hasLoop(Point first) {

	    if(first == null) // list does not exist..so no loop either.
	        return null;

	    Point slow, fast; // create two references.

	    slow = fast = first; // make both refer to the start of the list.

	    while(true) {

	        slow = slow.next;          // 1 hop.

	        if(fast.next != null)
	            fast = fast.next.next; // 2 hops.
	        else
	            return null;          // next node null => no loop.

	        if(slow == null || fast == null) // if either hits null..no loop.
	            return null;

	        if(slow == fast) // if the two ever meet...we must have a loop.
	            return slow;
	    }
	}	
	
	
	
	public static void main(String args[]){
		CycleDetection cd = new CycleDetection();
		Point p1 =new Point("1");
		Point p2 =new Point("2");
		Point p3 =new Point("3");
		Point p4 =new Point("4");
		Point p5 =new Point("5");
		Point p6 =new Point("6");
		Point p7 =new Point("7");
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p7;
		p7.next = p4;
		
		Point p = cd.hasLoop(p1);
		
		if(null == p){
			System.out.println("Good! There is no loop!");			
		}else{
			System.out.println("There is loop @ "+p.name);
		}
	}
}

class Point {
	public String name;
	
	public Point(String name){
		this.name = name;
	}
	
    public Point next;
    
    public boolean equals(Point point){
    	if(null == point)
    		return false;
    	else if(point.name == this.name)
    		return true;
    	else
    		return false;
    }
}


