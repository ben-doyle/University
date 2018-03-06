package planner;

// FAULTY IMPLEMENTATION

/**
 * <p>
 * An immutable class representing a traffic CorridorError from a start location in
 * the municipality to an end location in the municipality.
 * </p>
 *
 * <p>
 * Each traffic CorridorError has a maximum capacity: an integer greater than zero
 * that represents the maximum number of people who can use the CorridorError at the
 * same time. The start and end location in a traffic CorridorError cannot be equal.
 * </p>
 */
public class CorridorError implements Comparable<CorridorError> {

    // variables used for testing different errors
    private static boolean[] ERROR = { false, false, false, false, false };
    // private static boolean[] ERROR = { true, false, false, false, false };
    // private static boolean[] ERROR = { false, true, false, false, false };
    // private static boolean[] ERROR = { false, false, true, false, false };
    // private static boolean[] ERROR = { false, false, false, true, false };
    // private static boolean[] ERROR = { false, false, false, false, true };

    // the location that the traffic CorridorError starts at
    private Location start;
    // the location that the traffic CorridorError ends at
    private Location end;
    // the maximum capacity of the CorridorError -- integer units represent people
    private int capacity;

    /*
     * invariant:
     *
     * name!= null && start!= null && end!=null && !start.equals(end) &&
     * capacity > 0
     */

    /**
     * Creates a new traffic CorridorError with the given start and end locations,
     * and maximum capacity.
     *
     * @param start
     *            the start location of the traffic CorridorError
     * @param end
     *            the end location of the traffic CorridorError
     * @param capacity
     *            the maximum capacity of the traffic CorridorError
     * @throws NullPointerException
     *             if either start or end are null
     * @throws IllegalArgumentException
     *             if the start location is equal to the end location (according
     *             to the equals method of the Location class), or if capacity
     *             is less than or equal to zero
     */
    public CorridorError(Location start, Location end, int capacity) {
        if (start == null || end == null) {
            throw new NullPointerException(
                    "Neither the start or end location can be null.");
        }
        if (ERROR[0]) {
            // ERROR: don't throw an exception for capacity equal to 0
            if (capacity < 0) {
                throw new IllegalArgumentException(
                        "The maximum capacity of the traffic CorridorError "
                                + "must be greater than or equal to 0.");
            }
        } else {
            if (capacity <= 0) {
                throw new IllegalArgumentException(
                        "The maximum capacity of the traffic CorridorError "
                                + "must be greater than or equal to 0.");
            }
        }
        if (start.equals(end)) {
            throw new IllegalArgumentException(
                    "The start and end locations must be distinct.");
        }
        this.start = start;
        this.end = end;
        this.capacity = capacity;
    }

    /**
     * Returns the start location of this traffic CorridorError.
     *
     * @return the start location
     */
    public Location getStart() {
        return start;
    }

    /**
     * Returns the end location of this traffic CorridorError.
     *
     * @return the end location
     */
    public Location getEnd() {
        if (ERROR[1]) {
            // ERROR: as if we forgot to initialise end
            return null;
        } else {
            return end;
        }
    }

    /**
     * Returns the maximum capacity of the traffic CorridorError.
     *
     * @return the maximum capacity of this traffic CorridorError
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * <p>
     * This method returns a string of the form: <br>
     * <br>
     *
     * "CorridorError START to END (CAPACITY)" <br>
     * <br>
     *
     * where START and END are the toString() representations of the start and
     * end location of this CorridorError, respectively, and CAPACITY is the maximum
     * capacity of this traffic CorridorError. For example, the string representation
     * of a CorridorError having a start location with name "Annerly", end location
     * with name "City" and capacity 20 is "CorridorError Annerly to City (20)".
     * </p>
     */
    @Override
    public String toString() {
        return "CorridorError " + start + " to " + end + " (" + capacity + ")";
    }

    /**
     * <p>
     * This method returns true if and only if the given object (i) is an
     * instance of the class CorridorError, (ii) has a start location equal to the
     * start location of this CorridorError, (iii) an end location equal to the end
     * location of this CorridorError, and (iv) a maximum capacity equal to the
     * maximum capacity of this CorridorError.
     * </p>
     *
     * <p>
     * In the above description the equality of locations is determined using
     * the equals method of the Location class.
     * </p>
     */
    @Override
    public boolean equals(Object object) {
        if (ERROR[2]) {
            // ERROR: don't check condition (i)
        } else {
            if (!(object instanceof CorridorError)) {
                return false;
            }
        }
        CorridorError other = (CorridorError) object; // the CorridorError to compare
        if (ERROR[3]) {
            // ERROR: don't compare locations using proper equality
            return start == other.start && end == other.end
                    && capacity == other.capacity;
        } else {
            return start.equals(other.start) && end.equals(other.end)
                    && capacity == other.capacity;
        }
    }

    @Override
    public int hashCode() {
        // We create a polynomial hash-code based on start, end and capacity.
        final int prime = 31; // an odd base prime
        int result = 1; // the hash code under construction
        result = prime * result + start.hashCode();
        result = prime * result + end.hashCode();
        result = prime * result + capacity;
        return result;
    }

    /**
     * <p>
     * CorridorErrors are ordered primarily by their start location (in ascending
     * order using the natural ordering defined in the Location class), and then
     * (for CorridorErrors with equal start locations) by their end location (in
     * ascending order using the natural ordering defined in the Location
     * class), and then (for CorridorErrors with equal start locations and equal end
     * locations) by the (ascending order) of their capacity.
     * </p>
     *
     * <p>
     * For example, here is a list of CorridorErrors in order: <br>
     * <br>
     *
     * CorridorError Annerly to City (20)<br>
     * CorridorError Annerly to City (30)<br>
     * CorridorError Bardon to Ascot (40)<br>
     * CorridorError Bardon to City (10)<br>
     * CorridorError Bardon to Toowong (20)<br>
     * CorridorError City to Bardon (10)<br>
     *
     * </p>
     */
    @Override
    public int compareTo(CorridorError other) {
        int result = start.compareTo(other.start);
        if (result == 0) {
            result = end.compareTo(other.end);
        }
        if (ERROR[4]) {
            // ERROR: always compare by capacity alone
            result = capacity - other.capacity;
        } else {
            if (result == 0) {
                result = capacity - other.capacity;
            }
        }
        return result;
    }

    /**
     * <p>
     * Determines whether this class is internally consistent (i.e. it satisfies
     * its class invariant).
     * </p>
     *
     * <p>
     * NOTE: This method is only intended for testing purposes.
     * </p>
     *
     * @return true if this class is internally consistent, and false otherwise.
     */
    public boolean checkInvariant() {
        return (start != null && end != null && !start.equals(end)
                && capacity > 0);
    }

}
