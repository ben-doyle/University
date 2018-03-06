package week11;

import java.awt.Color;

public class ColoredPoint extends Point {

	private Color color; // the colour

	/** Create a new ColoredPoint with coordinates (0,0)
	 *  and given color.
	 */
	public ColoredPoint(Color color) {
		super(0,0);
		this.color = color;
	}
	
	public ColoredPoint() {
		this(Color.BLACK);
	}
	
	/** The color of this ColoredPoint. */
	public Color color() {
		return color;
	}

	public String toString () {
		return "ColoredPoint: x = " + x + 
				"; y = " + y + "; color = " + color;
	}
}

