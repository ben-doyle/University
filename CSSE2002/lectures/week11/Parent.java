package week11;

public class Parent {

	public void report() {
		System.out.println("class: Parent, no args");
	}
	
	public void myName() {
		System.out.println("Parent");
	}
	
	//for illustrating overriding resolution
	public void report(Object o) {
		System.out.println("class: Parent, Object arg");
	}
}
