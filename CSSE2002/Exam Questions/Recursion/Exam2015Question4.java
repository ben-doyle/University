package Recursion;


import java.util.ArrayList;
import java.util.List;

public class Exam2015Question4 {

    public static void main(String[] args) {
        Integer[] ar = {13, 14};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer i : ar) {
            arrayList.add(i);
        }

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        Integer[] ar2 = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 13};
        for (Integer i : ar2) {
            arrayList2.add(i);
        }

        System.out.println(intersect(arrayList, arrayList2));
        System.out.println(recursiveIntersect(arrayList, arrayList2));
    }

    /**
     * TODO: Recursive implementation
     */
    public static boolean recursiveIntersect(List<Integer> x, List<Integer> y) {
        if (y.size() == 0 || x.size() == 0) {
            return false;
        }
        return recursiveIntersect2(x, y, 0, 0);
    }

    private static boolean recursiveIntersect2(List<Integer> x, List<Integer>
            y, int k, int l) {
        if (x.get(k).equals(y.get(l))) {
            return true;
        }
        if (x.size() - 1 == k && y.size() - 1 == l) {
            return false;
        }
        if (x.get(k) < y.get(l)) {
            if (k < x.size() - 1) {
                k++;
            }
        } else {
            if (l < y.size() - 1) {
                l++;
            }
        }
        return recursiveIntersect2(x, y, k, l);
    }

    /**
     * Returns true if and only if the sorted arrays x and y
     * contain at least one integer in common.
     *
     * @require x!=null && y!=null && !x.contains(null) && !y.contains(null) &&
     * and both arrays of integers x and y are sorted in ascending (integer)
     * order.
     * @ensure \result is true iff there exists an integer n such that
     * x.contains(n) and y.contains(n)
     */
    public static boolean intersect(List<Integer> x, List<Integer> y) {
        int i = 0;
        int j = 0;
        while (i < x.size() && j < y.size()) {
            if (x.get(i).equals(y.get(j))) {
                return true;
            } else if (x.get(i) < y.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }

}
