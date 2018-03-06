package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam2009Question5 {

    public static void main(String[] args) {
        Integer[] intArray = {1, 1, 4, 5, 6, 8, 10};
        System.out.println(multiples(Arrays.asList(intArray), 2));
        System.out.println(recursiveMultiples(Arrays.asList(intArray), 2));
    }

    /** Return the elements of list which are multiples of n.
     * @require list != null && n > 0
     * @ensure  \result != null &&
     *          \result contains all elements m of list such that
     *          m % n == 0
     */
    public static List<Integer> recursiveMultiples(List<Integer> list, int i) {
        ArrayList<Integer> result = new ArrayList<>();
        if (list.size() == 0) {
            return new ArrayList<>();
        }
        if (list.get(0) % i == 0) {
            result.add(list.get(0));
        }
        result.addAll(recursiveMultiples(list.subList(1, list.size()), i));
        return result;
    }

    /** Return the elements of list which are multiples of n.
     * @require list != null && n > 0
     * @ensure  \result != null &&
     *          \result contains all elements m of list such that
     *          m % n == 0
     */
    public static List<Integer> multiples(List<Integer> list, int n) {
        List<Integer> result = new ArrayList<Integer>();
        //any list.get(j) j > 0 < i, i % n == 0
        //Every index less than i, (j) is a multiple of n, such that j % n == 0
        for (int i=0; i < list.size(); i++) {
            int m = list.get(i);
            if (m % n == 0) result.add(m);
        }
        return result;
    }

}
