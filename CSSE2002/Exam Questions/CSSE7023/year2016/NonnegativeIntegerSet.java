package CSSE7023.year2016;

public class NonnegativeIntegerSet {

    private final static int EMPTY = -1;
    private int[] table;

    /*
     * Class Invariant:
     *
     * table != null &&
     * this.contains(null) &&Has
     * this.getCapacity > 0 &&
     * this.size equals the number of non negative integers i stored in state such that this.contains(i) &&
     *
     *
     * for each int i in table, table[i] != null
     */

    /**
     * Creates a new empty set of non-negative integers with
     * the maximum capacity given.
     *
     * @require capacity >=0
     * @ensure Creates a new set such that this.getCapacity()
     *          equals capacity, and this.contains(x) is false
     *          for all integers x.
     */
    public NonnegativeIntegerSet(int capacity) {
        table = new int[capacity + 1];
        for (int i=0; i < table.length; i++) {
            table[i] = EMPTY;
        }

    }

    /**
     * Returns the maximum capacity of this set.
     *
     * @ensure \result is the maximum capacity of the set
     */
    public int getCapacity() {
        return table.length - 1;
    }

    /**
     * Checks to see if the integer set contains a particular
     * integer value.
     *
     * @ensure \result is true if and only if this set of
     *          integers contains an integer with the same value as x.
     */
    public boolean contains(int x) {
        if (x < 0) {
            return false;
        }
        int key = x % table.length;
        while (table[key] != EMPTY && table[key] != x) {
            key = (key + 1) % table.length;
        }
        return (table[key] == x);
    }

    /**
     * Adds a non-negative integer into the set.
     *
     * @require x >=0 && size < this.getCapacity()
     * @ensure if this.contains(x) is false, then this method
     *          adds the non-negative integer x into this set of
     *          integers (without adding or removing any other
     *          integers from the set). Otherwise, this operation
     *          does not change the set.
     */
    public void add (Integer x) {
        int key = x % table.length;
        while (table[key] != EMPTY && table[key] != x) {
            key = (key + 1) % table.length;
        }
        if (table[key] != x) {
            table[key] = x;
        }
    }

    /**
     * Returns the number of elements in this set.
     *
     * @ensure /result is the size of off all integer
     *          values v such this this.contains(v). the set
     *          is not modified in any way by this operation.
     */
    public int size() {
        int result = 0;
        for (int i : table) {
            if (i > 0) {
                result++;
            }
        }
        return result;
    }

    public String toString() {
        String result = "[" + table[0];
        for (int i=1; i < table.length; i++) {
            result += ", " + table[i];
        }
        result += "]";
        return result;
    }
}
