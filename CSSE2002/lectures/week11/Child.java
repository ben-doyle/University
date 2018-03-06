package week11;


public class Child extends Parent {

	public void report(int x) {
		System.out.println("class: Child, int arg");
	}

	public void report(Object x) {
		System.out.println("class: Child, Object arg");
	}

	public void report(ColoredPoint x) {
		System.out.println("class: Child, ColoredPoint arg");
	}
	
	public void myName() {
		System.out.println("Child");
	}
	
	public void myParent() {
		super.myName();
	}
}
