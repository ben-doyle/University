import java.io.*;
import java.lang.*;
import java.util.*;

public class Example1 {

    public static void main(String[] args) {
        LinkedList<Integer> ints = new LinkedList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);

        System.out.println(combinations(ints, 2));
    }

    public static <E> Set<Set<E>> combinations(List<E> groupSize, int k) {

        Set<Set<E>> allCombos = new HashSet<> ();
        // base cases for recursion
        if (k == 0) {
            // There is only one combination of size 0, the empty team.
            allCombos.add(new HashSet<>());
            return allCombos;
        }
        if (k > groupSize.size()) {
            // There can be no teams with size larger than the group size,
            // so return allCombos without putting any teams in it.
            return allCombos;
        }

        // Create a copy of the group with one item removed.
        List<E> groupWithoutX = new ArrayList<> (groupSize);
        E x = groupWithoutX.remove(groupWithoutX.size()-1);

        Set<Set<E>> combosWithoutX = combinations(groupWithoutX, k);
        Set<Set<E>> combosWithX = combinations(groupWithoutX, k-1);
        for (Set<E> combo : combosWithX) {
            combo.add(x);
        }
        allCombos.addAll(combosWithoutX);
        allCombos.addAll(combosWithX);
        return allCombos;
    }

}
