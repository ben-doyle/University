package week10;

public class Interfaces {

	public static void main(String[] args) {
		ClosedFigure cf;
		// cf = new ClosedFigure();
		cf = new Circle(1.0);
		System.out.println(cf.area());
		System.out.println(cf.perimeter());
		//System.out.println(cf.radius());
		printArea(cf);
		
		cf = new Rectangle(3,4);
		System.out.println(cf.area());
		System.out.println(cf.perimeter());
		System.out.println(((Rectangle) cf).length());
		//System.out.println(((Circle) cf).radius());
		printDiagonal((Rectangle) cf);
		
		System.out.println(cf instanceof ClosedFigure);
		System.out.println(cf instanceof Circle);
		System.out.println(cf instanceof Rectangle);
		System.out.println(cf instanceof Polygon);
	}

	public static void printArea(ClosedFigure figure) {
		double area = figure.area();
		System.out.println(area);
	}
	
	public static void printDiagonal(Rectangle rect) {
		double diagonal = Math.sqrt(
				rect.length()*rect.length() + 
				rect.width()*rect.width());
		System.out.println(diagonal);
	}
	
	/* Usually poor style to use instanceof. It would be better
	 * if this method required a Rectangle. The calling code should 
	 * know the type of the object and cast it to Rectangle, if 
	 * necessary.
	 */
	public static void printWidth(ClosedFigure figure) {
		if (figure instanceof Rectangle) {
			double width = ((Rectangle)figure).width();
			System.out.println(width);
		} else
			System.out.println("Not a Rectangle."); 
	}
}
