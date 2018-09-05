package com.chandler.exp.interview;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PreidcateConsumerDemo {

	public static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer, Consumer<Student> c2) {
		
//		// Use the predicate to decide when to update the discount.
//		if (predicate.test(student)) {
//			// Use the consumer to update the discount value.
//			consumer.accept(student);
//		}
		
		
		//more experiment of predicate and consumer.......
		//the original code above is commented out......
		Predicate<Student> test = (Object)->true;
		
		//chain two predicates then test with the 3rd one
		if(predicate.and(test).test(student)){
			//chain 2 operations, must call accept to operate
//			consumer.andThen(c2).accept(student);
			//the accept functional method can also be defined here with the parameter "Object"
			Consumer<Student> c3 = Object -> System.out.println("I'm c3 !");
			consumer.andThen(c3).accept(student);
		}

		return student;

	}

	public static void main(String[] args) {
		Student student1 = new Student("Ashok", "Kumar", 9.5);

		student1 = updateStudentFee(student1,
				student -> student.grade > 8.5,//call test method of predicate
				student -> student.feeDiscount = 30.0,//call accept method of consumer
						student -> System.out.println("Ashok Kumar"));

		student1.printFee();

		Student student2 = new Student("Rajat", "Verma", 8.0);

		student2 = updateStudentFee(student2,
				student -> student.grade >= 8,
				student -> student.feeDiscount = 20.0,
						student -> System.out.println("Rajat Verma"));

		student2.printFee();

		Function<String,String> f = (s) -> s.concat(s);
		System.out.println(f.apply("abc"));
		
		
	}

}
