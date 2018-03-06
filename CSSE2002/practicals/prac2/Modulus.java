package prac2;

public class Modulus {
	
	public static void main(String [] args) {
		ModulusCounter m = new ModulusCounter(5);
		m.incrementCount();
		System.out.println(m.toString());
		m.reset();
		System.out.println(m.toString());
		m.incrementCount();
		m.incrementCount();
		m.incrementCount();
		m.incrementCount();
		m.incrementCount();
		System.out.println(m.toString());
		m.incrementCount();
		m.incrementCount();
		System.out.println(m.toString());
	}

}


