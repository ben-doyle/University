package week11;

/** A point with integer coordinates. */
public class Point {

	protected int x; // the x-coordinate
	protected int y; // the y-coordinate

	/** Create a new Point with coordinates (x,y).
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/** The x coordinate of this Point. */
	public int getX() {
		return x;
	}

	/** The y coordinate of this Point. */
	public int getY() {
		return y;
	}

	/** Set the x coordinate to the specified value.
	 */
	public void setX(int value) {
		x = value;
	}

	/** Set the y coordinate to the specified value.
	 */
	public void setY(int value) {
		y = value;
	}

	public String toString() {
		return "Point: x = " + x + "; y = " + y;
	}
}
