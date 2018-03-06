package week4;

/** An immutable case-insensitive name. */
public class CaseInsensitiveName extends Name {

    /**
     * Create a new case-insensitive name with the specified
     * first and last names.
     * @param first
     *            the first name
     * @param last
     *            the last name
     */
    public CaseInsensitiveName(String first, String last) {
        super(first, last);
    }

    // This is wrong. You should NOT override equals in this
    // class
    public boolean equals(Object o) {
        if (!(o instanceof CaseInsensitiveName)) {
            // return false;
            // changed to solve symmetry problem
            return super.equals(o);
        }
        CaseInsensitiveName n = (CaseInsensitiveName) o;
        return sameLetters(getFirstName(), n.getFirstName())
                && sameLetters(getLastName(),
                        n.getLastName());
    }

    private boolean sameLetters(String s, String t) {
        return s.toLowerCase().equals(t.toLowerCase());
    }

}
