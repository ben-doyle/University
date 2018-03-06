package Recursion;

import java.util.ArrayList;
import java.util.List;


public class Exam2016Question4 {
    public static void main(String[] args) {
        int[] xArray = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> x = new ArrayList<>();
        for (int i : xArray) {
            x.add(i);
        }

        System.out.println(longestSuffix(x));
        System.out.println(recursiveLongestSuffix(x));
    }

    /**
     * Returns the longest suffix of the list x that has no
     * repeated elements
     *
     * @require x!= null && !x.contains(null)
     * @ensure This operation does not modify the input list x. It returns the
     * longest suffix of the list x that has no repeated elements.
     */
    public static List<Integer> longestSuffix(List<Integer> x) {
        List<Integer> suffix = new ArrayList<>();
        int j = x.size() - 1;
        while (j >= 0) {
            if (!suffix.contains(x.get(j))) {
                // appends x.get(j) to the front of suffix
                suffix.add(0, x.get(j));
                j = j - 1;
            } else {
                j = -1;
            }
        }
        return suffix;
    }

    private static List<Integer> longestSuffixRecursionExample(List<Integer> x) {
        if(x.size() < 2){
            return x;
        }
        List<Integer> tailSuffix = longestSuffixRecursionExample(x.subList(1, x.size()));
        return tailSuffix.size() == x.size() - 1 && !tailSuffix.contains(x.get(0)) ? x : tailSuffix;
    }

    /**
     * TODO: Recursive implementation
     */
    public static List<Integer> recursiveLongestSuffix(List<Integer> x) {
       return  recursiveLongestSuffix(x, 0);
    }

    public static List<Integer> recursiveLongestSuffix(List<Integer> x, int last) {
        List<Integer> suffix = new ArrayList<>();
        if (last == x.get(x.size() - 1)) {
            return new ArrayList<>();
        }
        last = x.get(x.size() - 1);
        suffix.add(suffix.size(), last);
        suffix.addAll(recursiveLongestSuffix(x.subList(0, x.size() - 1), last));
        return suffix;
    }
}

