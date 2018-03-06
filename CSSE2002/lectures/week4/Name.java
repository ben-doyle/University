package week4;

/** An immutable name. */
public class Name implements Comparable<Name>, Cloneable {

    private String first; // first name
    private String last; // last name

    /**
     * Create a new Name with the specified first and last
     * names.
     * @param first
     *            the first name of the new name
     * @param last
     *            the last name of the new name
     */
    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    /**
     * Get the first name of this Name.
     * @return the first name
     */
    public String getFirstName() {
        return first;
    }

    /**
     * Get the last name of this Name.
     * @return the last name
     */
    public String getLastName() {
        return last;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Name)) {
            return false;
        }
        Name n = (Name) o;
        return first.equals(n.first) && last.equals(n.last);
    }

    @Override
    public int hashCode() {
        return first.hashCode() + last.hashCode();
    }

    @Override
    public int compareTo(Name n) {
        int result = last.compareTo(n.last);
        if (result == 0) {
            result = first.compareTo(n.first);
        }
        return result;
    }

    @Override
    public Object clone()
            throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return first + " " + last;
    }

}