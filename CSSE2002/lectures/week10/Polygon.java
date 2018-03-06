package week10;

/** A closed figure with a finite number of 
 * straight sides.
 */
public interface Polygon extends ClosedFigure {
  
  /** The number of sides of this Polygon.
   * @ensure result >= 3
   */
  public int sides();
  
}
