package Recursion;


import java.util.ArrayList;
import java.util.List;

public class Exam2014Question3 {
    public static void main(String[] args) {
        Integer[] aArray = {1, 5, 11, 6, 9};
        Integer[] bArray = {3, 6, 4, 2, 11};
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        for (int i = 0; i < aArray.length; i++){
            a.add(aArray[i]);
            b.add(bArray[i]);
        }

        System.out.println(pairwiseMin(a, b));
        System.out.println(recursivePairwiseMin(a, b));
    }

    /**
     *
     * @require a!= null && b!=null && a.size() == b.size() && !a.contains(null)
     * && !b.contains(null)
     * @ensure \result is an array of size a.size() such that for each index j
     * of \result, c.get(j) is the minimum of a.get(j) and b.get(j)
     */
    private static List<Integer> recursivePairwiseMin(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        if (a.size() == 0) {
            return new ArrayList<>();
        }
        result.add((a.get(0) < b.get(0) ? a.get(0) : b.get(0)));
        result.addAll(recursivePairwiseMin(a.subList(1, a.size()), b.subList(1, b.size())));
        return result;
    }

    /**
     *
     * @require a!= null && b!=null && a.size() == b.size() && !a.contains(null)
     * && !b.contains(null)
     * @ensure \result is an array of size a.size() such that for each index j
     * of \result, c.get(j) is the minimum of a.get(j) and b.get(j)
     */
    public static List<Integer> pairwiseMin(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<Integer>();
        int i = 0;
        while (i < a.size()) {
            if (a.get(i) <= b.get(i)) {
                c.add(a.get(i));
            } else {
                c.add(b.get(i));
            }
            i++;
        }
        return c;
    }

}
