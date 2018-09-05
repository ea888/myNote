package com.chandler.exp.interview;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class TestNull implements FTest1,FTest2{
	int a = 1;

	@Override
	public void hello() {
		// TODO Auto-generated method stub
		//FTest1.super.hello();
		System.out.println("Hello3!");
	}
}

@interface column{
	
}

interface FTest1{
	default void hello(){
		System.out.println("Hello1!");
	}
}

interface FTest2{
	default void hello(){
		System.out.println("Hello2!");
	}
}

class FinallyTest{
	public void test(){
		try{
			System.out.println("First test!");
		}finally{
			System.out.println("First finally Block!");
		}
		
		try{
			System.out.println("Second test!");
		}finally{
			System.out.println("second finally Block!");
		}
	}
}

public class JavaTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNull tn = new TestNull();
		TestNull tn2 = tn;
//		tn2 = null;
		tn2.a = 2;
		
		System.out.println(tn.a);
		
		tn2.hello();
		
		
		//lambda - anonymous inner class
		new Thread(()->{
			System.out.println("Thread Started!");
		}).start();
		
		//implements comparator
		Comparator<String> c = (s1, s2) -> s1.compareToIgnoreCase(s2);
		c.compare("Jordan", "Kobe");
		
		//This is before java8
		List<AppleAnnotation> apple = new ArrayList<AppleAnnotation>();
		Collections.sort(apple, new Comparator<AppleAnnotation>() {
			public int compare(AppleAnnotation x, AppleAnnotation y) {
				return x.getAppleName().compareTo(y.getAppleName());
			}
		});
		//use lambda
		Collections.sort(apple, (a1,a2) -> a1.getAppleName().compareTo(a2.getAppleName()));
		Collections.sort(apple, Comparator.comparing((AppleAnnotation p) -> p.getAppleName()));
		Collections.sort(apple, Comparator.comparing(AppleAnnotation::getAppleName));
		apple.sort(Comparator.comparing(AppleAnnotation::getAppleName));
		
		
		FinallyTest ft = new FinallyTest();
		ft.test();
		
		List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
		
		splitUpNames.forEach(item -> System.out.println("First:"+item[0]+" Last:"+item[1]));
		
		ReferenceQueue rq = new ReferenceQueue();
		String str = "Soft";
		SoftReference<String> softRef = new SoftReference<>(str,rq);
		str = null;
		softRef.enqueue();
		
		System.out.println("Original:"+str+" Queue:"+rq.poll().get()+" soft:"+softRef.get());
	}

}
