package chapter2;

/**
 * Models a counter, in which you can set the value it counts to,
 * resets once the count hits that number.
 */
public class ModulusCounter {
    int count;
    int maxCount;

    /**
     * Creates new Modulus Counter with count set to 0
     * @param maxCount
     */
    ModulusCounter(int maxCount) {
        count = 0;
        this.maxCount = maxCount;
    }

    //Queries

    /**
     * the current count.
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * maxCount when object was initialised.
     * @return the maxCount
     */
    public int getMaxCount() {
        return maxCount;
    }

    //Commands

    /**
     * Resets the counter to 0
     */
    public void reset() {
        count = 0;
    }

    /**
     * If counter is equal to maxCount, resets counter.
     * Else, increments counter by 1.
     */
    public void incrementCount() {

        if (count == maxCount) {
            this.reset();
        }
        else {
            count++;
        }
    }
}
