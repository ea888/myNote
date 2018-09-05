package exp;

import java.util.*;

public class ShallowClone {

	public List<Protein> copied,copied2;
	
	public void shallowCopy(List<Protein> proteins){
		List<Protein> newPs = (ArrayList<Protein>)((ArrayList<Protein>)proteins).clone();
//		newPs.remove(0);
//		newPs.add(new Protein("Destroyed"));
		newPs.get(0).setName("Destroyed!");
		
		System.out.println("destroy:");
		newPs.forEach((item)->System.out.println(item.name));
		
	}
	
	public void shallowCopy2(List<Protein> proteins){
		List<Protein> newPs = new ArrayList<>(proteins);
//		newPs.remove(0);
//		newPs.add(new Protein("Destroyed"));
		newPs.get(0).setName("Destroyed!");
		
		System.out.println("shallow copy2:");
		newPs.forEach((item)->System.out.println(item.name));
		
	}
	
	public void shallowCopy3(List<Protein> proteins){
		this.copied = new ArrayList<>(proteins);	
		this.copied2 = (ArrayList<Protein>)((ArrayList<Protein>)proteins).clone();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Protein> ps = new ArrayList<>();
		ps.add(new Protein("Whey"));
		ps.add(new Protein("Casein"));
		
		ShallowClone sc = new ShallowClone(); 
		sc.shallowCopy2(ps);
		
		System.out.println("original:");
		ps.forEach((item)->System.out.println(item.name));
		
		sc.shallowCopy3(ps);
		ps.get(0).setName("Whey!");
		
		System.out.println("copy:");
		sc.copied.forEach((item)->System.out.println(item.name));
		System.out.println("copy2:");
		sc.copied2.forEach((item)->System.out.println(item.name));
		
	}

}

class Protein{
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Protein(String name){
		this.name = name;
	}
}
