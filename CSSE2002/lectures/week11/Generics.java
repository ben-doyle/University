package week11;

import java.util.ArrayList;
import week10.Circle;
import week10.ClosedFigure;
import week10.Rectangle;

public class Generics {

	public static void main(String [] args) {
		ColoredPoint cp = new ColoredPoint();
		Pair<String,ColoredPoint> p = 
			new Pair<String,ColoredPoint>("abc",cp);
		System.out.println(p.getSecond().color());
		
		ArrayList<ClosedFigure> shapes = 
			new ArrayList<ClosedFigure>();
		shapes.add(new Circle(2));
		shapes.add(new Rectangle(3,4));
		shapes.add(new Circle(1));
		System.out.println("elements = " + numberElements(shapes));
		System.out.println("total area = " + totalArea(shapes));
		addCircle(shapes,new Circle(3)); 
		
		ArrayList<Circle> circles = 
			new ArrayList<Circle>();
		circles.add(new Circle(3));
		circles.add(new Circle(5));
		System.out.println("elements = " + numberElements(circles));
		System.out.println("total area = " + totalArea(circles));
		addCircle(circles,new Circle(3));
		
	}
	
	//public static <T> int numberElements(ArrayList<T> list) {
	public static int numberElements(ArrayList<?> list) {
		return list.size();
	}
		
	//public static <T extends ClosedFigure> double totalArea(ArrayList<T> list) {
	public static double totalArea(ArrayList<? extends ClosedFigure> list) {
		double sum = 0;
		for (ClosedFigure s: list)
			sum += s.area();
		return sum;
	}
	
	public static void addCircle(ArrayList<? super Circle> list, Circle c) {
		list.add(c);
	}
	
}
