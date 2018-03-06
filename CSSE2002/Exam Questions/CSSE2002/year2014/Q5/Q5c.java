package CSSE2002.year2014.Q5;

public class Q5c {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		b = (B) a;
		char[] chars = b.getChars("abc");
	}

}
