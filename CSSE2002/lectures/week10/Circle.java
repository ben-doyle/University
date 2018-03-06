package week10;

/** A circle. */
public class Circle implements ClosedFigure, Resizable {

	private double radius;

	/** Create a new Circle with the specified radius.
	 *  @require radius >= 0.0
	 */
	public Circle(double radius) {
		this.radius = radius;
	}

	/** Scales this Resizable by a factor of n.
 	 *  @require n >= 0	(Note that precondition is weakened.)
	 *  @ensure area = \old(area) * n
 	 */
	public void resize(int n) {
		radius = Math.sqrt(n)*radius;
	}
	
	public double area() {
		return Math.PI*radius*radius;
	}
	
	/** Returns the circumference of this Circle. */
	public double perimeter() {
		return 2*Math.PI*radius;
	}
	
	/** The radius of this Circle.
	 *  @ensure result >= 0.0
	 */
	public double radius() {
		return radius;
	}

	public String toString() {
		return "Circle: radius: " + radius;
	}

}
