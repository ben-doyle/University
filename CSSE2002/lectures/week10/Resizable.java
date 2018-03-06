package week10;

/** A object that can be resized. */
public interface Resizable {

	/** Scales this Resizable by a factor of n.
 	 *  @require n > 0
	 *  @ensure area = \old(area) * n
 	 */
	public void resize(int n);
	
}

