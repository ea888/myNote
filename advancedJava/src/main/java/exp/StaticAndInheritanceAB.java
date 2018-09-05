package exp;

public class StaticAndInheritanceAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		A a = new A();
		a.go();
		b.go();
		B.go();
		A.go();
	}

}
