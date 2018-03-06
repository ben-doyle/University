package week11;

import java.awt.Color;

public class Inheritance {

	public static void main(String [ ] args) {
		// class extension
		ColoredPoint cp = new ColoredPoint(Color.RED);
		cp.setX(10);
		System.out.println(cp);

		//constructors and extension
		Point pcp = new ColoredPoint();
		System.out.println("Point pcp = new ColoredPoint() prints out: \n" + pcp + "\n");
		
		// method overloading
		Child c = new Child();
		c.report();
		c.report(2);
		c.report("abc");
		c.report(cp);  // most specific method chosen
		c.report(pcp); // method based on declared type of parameter
		
		// method overriding
		Parent p = new Parent();
		Parent pc = new Child();
		p.myName();
		c.myName();
		pc.myName();  // method based on actual type of object
		c.myParent();
		
		// for illustrating overriding resolution
		p.report("abc");
		c.report("abc");
		pc.report("abc");
		
		p.report(cp);
		c.report(cp);
		pc.report(cp);
		
		p.report(pcp);
		pc.report(pcp);
		c.report(pcp);
	}

}
