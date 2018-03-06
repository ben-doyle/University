package week10;

/**
 * A rectangle.
 */
public class Rectangle implements Polygon {

    private double length;
    private double width;

    /**
     * Create a new Rectangle with the specified length and
     * width.
     *
     * @require length >= 0.0 && width >= 0.0
     * @ensure this.length == length && this.width == width
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * The number of sides of this Polygon.
     *
     * @ensure result == 4 	  (Note that postcondition strengthened.)
     */
    public int sides() {
        return 4;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    /**
     * The length of this Rectangle.
     *
     * @ensure result >= 0
     */
    public double length() {
        return length;
    }

    /**
     * The width of this Rectangle.
     *
     * @ensure width >= 0
     */
    public double width() {
        return width;
    }

    public String toString() {
        return "Rectangle: length: " + length + ", width: " + width;
    }
}


