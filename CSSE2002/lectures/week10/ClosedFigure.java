package week10;

/** A closed two-dimensional figure. */
public interface ClosedFigure {
  
  /** The area of this ClosedFigure.
   *  @ensure result >= 0
   */
  public double area();
  
  /** The perimeter of this ClosedFigure.
   *  @ensure result >= 0
   */
  public double perimeter();
}
