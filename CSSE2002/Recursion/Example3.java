import java.io.*;
import java.lang.*;
import java.util.*;

public class Example3 {

    public static void main(String[] args) {
        Set<Integer> ints = new HashSet<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);

        Set<Integer> ints2 = new HashSet<>();
        ints2.add(1);
        ints2.add(2);
        ints2.add(3);
        ints2.add(4);
        ints2.add(5);

        ArrayList<Set<Integer>> ar = new ArrayList<>();
        ar.add(ints);
        ar.add(ints2);

        System.out.println(cartesianProduct(ar));
    }


    public static <T> List<Tuple<T>> cartesianProduct(List<Set<T>> sets) {
        List<Tuple<T>> tuples = new ArrayList<Tuple<T>>();

        if (sets.size() == 1) {
            Set<T> set = sets.get(0);
            for (T t : set) {
                Tuple<T> tuple = new Tuple<T>();
                tuple.add(t);
                tuples.add(tuple);
            }
        } else {
            Set<T> set = sets.remove(0);
            List<Tuple<T>> subTuples = cartesianProduct(sets);
            for (Tuple<T> subTuple : subTuples) {
                for (T t : set) {
                    Tuple<T> tuple = new Tuple<T>();
                    tuple.addAll(subTuple);
                    tuple.add(t);
                    tuples.add(tuple);
                }
            }
        }

        return tuples;
    }
}

class Tuple<T> {
    private List<T> list = new ArrayList<T>();

    public void add(T t) { list.add(t); }

    public void addAll(Tuple<T> subT) {
        for (T t : subT.list) {
            list.add(t);
        }
    }

    public String toString() {
        String result = "(";

        for (T t : list) { result += t + ", "; }

        result = result.substring(0, result.length() - 2);
        result += " )";

        return result;
    }
}

