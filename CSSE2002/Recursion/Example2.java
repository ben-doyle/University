import java.io.*;
import java.lang.*;
import java.util.*;

public class Example2 {

    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);

        System.out.println(powerSet(s));
    }

    public static <E> Set<Set<E>> powerSet(Set<E> originalSet) {
        Set<Set<E>> sets = new HashSet<Set<E>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<E>());
            return sets;
        }
        List<E> list = new ArrayList<E>(originalSet);
        E head = list.get(0);
        Set<E> rest = new HashSet<E>(list.subList(1, list.size()));
        for (Set<E> set : powerSet(rest)) {
            Set<E> newSet = new HashSet<E>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
