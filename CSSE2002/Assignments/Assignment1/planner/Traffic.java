package planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 * A mutable class for recording the amount of traffic on traffic corridors.
 * </p>
 * <p>
 * <p>
 * The traffic on a corridor is measured in non-negative integer units,
 * representing people.
 * </p>
 */
public class Traffic {

    // List of corridors
    private ArrayList<Corridor> corridors = new ArrayList<>();
    // Traffic - hashmap used to store traffic on each corridor
    private HashMap<Corridor, Integer> traffic = new HashMap<>();

    //Correct line separator for executing machine (used in toString method)
    private final static String LINE_SEPARATOR = System.getProperty(
            "line.separator");

    /*  Invariant:
     *  corridors != null &&
     *  traffic != null &&
     *  for each c in traffic.get(c) != null
     */

    /**
     * <p>
     * Creates a new instance of the class in which every traffic corridor
     * initially has no (i.e. zero) traffic.
     * </p>
     * <p>
     * <p>
     * That is, for any non-null traffic corridor c, this.getTraffic(c) == 0.
     * </p>
     */
    public Traffic() {

    }

    /**
     * <p>
     * Creates a new instance of this class that initially has the same traffic
     * as parameter initialTraffic.
     * </p>
     * <p>
     * <p>
     * The parameter initialTraffic should not be modified by this method.
     * Furthermore, future changes to the parameter initialTraffic should not
     * affect this instance of the class, and vice versa. That is, the new
     * instance of the class should be a deep copy of initialTraffic.
     * </p>
     *
     * @param initialTraffic the initial traffic for this instance of the class
     * @throws NullPointerException if initialTraffic is null
     */
    public Traffic(Traffic initialTraffic) throws NullPointerException {
        if (initialTraffic.equals(null)) {
            throw new NullPointerException("initialTraffic is null.");
        } else {
            for (Corridor c : initialTraffic.getCorridorsWithTraffic()) {
                corridors.add(c);
                traffic.put(c, initialTraffic.getTraffic(c));
            }
        }
    }

    /**
     * <p>
     * Returns the amount of traffic on the given corridor.
     * </p>
     * <p>
     * <p>
     * The amount of traffic on a corridor is always non-negative, meaning that
     * this method always a returns an integer that is greater than or equal to
     * zero.
     * </p>
     *
     * @param corridor the corridor whose associated amount of traffic will be
     *                 returned
     * @return the amount of traffic on the given corridor
     * @throws NullPointerException if the parameter corridor is null
     */
    public int getTraffic(Corridor corridor) {
        if (corridor == null) {
            throw new NullPointerException("Corridor is null.");
        }
        return traffic.getOrDefault(corridor, 0);
    }

    /**
     * Returns the set of all traffic corridors c for which this.getTraffic(c)
     * is greater than zero.
     *
     * @return the set of traffic corridors with an amount of traffic that is
     * greater than zero
     */
    public Set<Corridor> getCorridorsWithTraffic() {
        Set<Corridor> returnSet = new HashSet<>();
        for (Corridor c : corridors) {
            if (traffic.get(c) > 0) {
                returnSet.add(c);
            }
        }
        return returnSet;
    }

    /**
     * <p>
     * Returns true if parameter other currently records the same traffic as
     * this traffic record, and false otherwise.
     * </p>
     * <p>
     * <p>
     * That is, it returns true if and only if for every traffic corridor, the
     * traffic currently on that corridor in this object equals the traffic
     * currently on that corridor in the other object.
     * </p>
     *
     * @param other the Traffic object to compare
     * @return true if this object and other currently record the same traffic,
     * and false otherwise
     * @throws NullPointerException if other is null
     */
    public boolean sameTraffic(Traffic other) {
        if (other == null) {
            throw new NullPointerException("Traffic is null.");
        }
        for (Corridor c : corridors) {
            if (!traffic.get(c).equals(other.traffic.get(c))) {
                return false;
            } else if (traffic.containsKey(c) && !other.traffic.containsKey(c)){
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Updates the traffic on the given corridor by adding parameter amount to
     * the existing traffic on the corridor.
     * </p>
     * <p>
     * <p>
     * Parameter amount may be either a negative or positive integer (or zero),
     * but an InvalidTrafficException will be thrown if the result of adding
     * amount to the current traffic on the corridor will result in a negative
     * quantity of traffic on that corridor.
     * </p>
     *
     * @param corridor the corridor whose amount of traffic will be updated
     * @param amount   the amount that will be added to the traffic on the given
     *                 corridor
     * @throws NullPointerException    if corridor is null
     * @throws InvalidTrafficException if the addition of amount and the current
     *                                 amount of traffic on the given corridor
     *                                 is negative (i.e. less than zero).
     */
    public void updateTraffic(Corridor corridor, int amount) {
        if (corridor == null) {
            throw new NullPointerException("Corridor is null.");
        }
        if (corridors.contains(corridor)) {
            if ((traffic.get(corridor) + amount) < 0) {
                throw new InvalidTrafficException("Traffic + amount < 0.");
            }
            traffic.put(corridor, traffic.get(corridor) + amount);
        } else {
            if (amount < 0) {
                throw new InvalidTrafficException("Amount must be > 0.");
            }
            corridors.add(corridor);
            traffic.put(corridor, amount);
        }
    }

    /**
     * <p>
     * This method adds all of the traffic defined by parameter extraTraffic to
     * this object.
     * </p>
     * <p>
     * <p>
     * That is, for each traffic corridor c, this method updates the traffic on
     * that corridor in this object by adding to it the traffic that parameter
     * extraTraffic associates with c.
     * </p>
     * <p>
     * <p>
     * (Unless this == extraTraffic) this method must not modify the given
     * parameter, and future modifications to this object should not affect the
     * parameter extraTraffic and vice versa.
     * </p>
     *
     * @param extraTraffic the traffic to be added to this object
     * @throws NullPointerException if extraTraffic is null
     */
    public void addTraffic(Traffic extraTraffic) {
        if (extraTraffic == null) {
            throw new NullPointerException("extraTraffic is null.");
        }
        for (Corridor c : extraTraffic.corridors) {
            if (corridors.contains(c)) {
                traffic.put(c, traffic.get(c) + extraTraffic.getTraffic(c));
            } else {
                corridors.add(c);
                traffic.put(c, extraTraffic.getTraffic(c));
            }
        }
    }

    /**
     * <p>
     * The string representation is the concatenation of strings of the form
     * <br>
     * <br>
     * <p>
     * "CORRIDOR: TRAFFIC" + LINE_SEPARATOR <br>
     * <br>
     * <p>
     * where CORRIDOR is the toString() representation of a traffic corridor c
     * for which this.getTraffic(c) is greater than zero, and TRAFFIC is its
     * corresponding amount of traffic, and LINE_SEPARATOR is the line separator
     * retrieved in a machine-independent way by calling
     * System.getProperty("line.separator").
     * </p>
     * <p>
     * <p>
     * In the string representation, the corridors should appear in the order of
     * their natural ordering (i.e. using the order defined by the compareTo
     * method in the Corridor class).
     * </p>
     * <p>
     * <p>
     * If there are no traffic corridors c for which this.getTraffic(c) is
     * greater than zero, then the string representation is the empty string "".
     * </p>
     * <p>
     * <p>
     * (Note that we have one line for each corridor with a non-zero amount of
     * traffic in this string representation, and no lines for corridors with a
     * zero amount of traffic.)
     * </p>
     */
    @Override
    public String toString() {
        String result = "";
        for (Corridor c : corridors) {
            result += c.toString() + ": " + this.getTraffic(c) + LINE_SEPARATOR;
        }
        return result;
    }

    /**
     * <p>
     * Determines whether this class is internally consistent (i.e. it satisfies
     * its class invariant).
     * </p>
     * <p>
     * <p>
     * NOTE: This method is only intended for testing purposes.
     * </p>
     *
     * @return true if this class is internally consistent, and false otherwise.
     */
    public boolean checkInvariant() {
        for (Corridor c : corridors) {
            if (c == null) {
                return false;
            }
        }
        return corridors != null && traffic != null;
    }

}
