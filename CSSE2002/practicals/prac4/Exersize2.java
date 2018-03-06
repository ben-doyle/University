package prac4;

import java.util.HashSet;
import java.util.Set;

public class Exersize2 {

    public static void main(String[] args) {
        System.out.println(subsets(1, 5));
    }

    /**
     * Returns a set containing all possible subsets of integers in
     * the range [first, last].
     * <p>
     * E.g. subsets(1,1) = { {}, {1} } and
     * subsets(1,2) = { {}, {1}, {2}, {1,2} }
     * and for an empty range, i.e. [5,3], we have that
     * subsets(5,3) = {{}}
     */
    public static Set<Set<Integer>> subsets(int first, int last) {
        Set<Set<Integer>> result = new HashSet<>();
        if (first > last) {
            result.add(new HashSet<Integer>());
            return result;
        }
        // recursive case: range is non-empty
        // set result = subsets(first+1, last) union {s:subsets(first+1,last) @ s union {first}}
        Set<Set<Integer>> subsets = subsets(first + 1, last);
        for (Set<Integer> subset : subsets) {
            result.add(subset);
            Set<Integer> copy = new HashSet<>(subset);
            copy.add(first);
            result.add(copy);
        }
        return result;
    }
}
