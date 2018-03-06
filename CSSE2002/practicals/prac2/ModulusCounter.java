package prac2;

/**
 * A simple integer modulo counter.
 * 
 * @author: Benjamin Doyle
 * @version: 1.0
 */
public class ModulusCounter {

	private int count;
	private int maximumCount;

	/**
	 * Create a new Counter, with the count initialized to 0.
	 * 
	 * @param max the max that the counter goes up to before
	 * resetting.
	 */
	public ModulusCounter(int max) {
		maximumCount = max;
		count = 0;
	}

	/**
	 * The number of items counted.
	 * 
	 * @return returns an integer representing the current count.
	 */
	public int currentCount() {
		return maximumCount % count;
	}

	/**
	 * Increment the count by 1.
	 */
	public void incrementCount() {
		count += 1;
		if (count == maximumCount)
			reset();
	}

	/**
	 * Reset the count to 0.
	 */
	public void reset() {
		count = 0;
	}

	@Override
    public String toString() {
	    return "Counter, Count: " + count + " Maximum Count: " + maximumCount;
    }

}
