package Recursion;

import java.util.ArrayList;

public class Exam2012Question4 {

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(4);
        ar.add(5);
        ar.add(7);
        ar.add(3);
        ar.add(5);
        System.out.println(multiply(ar));
        System.out.println(recursiveMultiply(ar));
    }

    /**
     * TODO: Recursive implementation.
     */
    private static ArrayList<Integer> recursiveMultiply(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return new ArrayList<>();
        }
        return recursiveMultiply(list, 1);
    }

    /**
     * TODO: Recursive implementation.
     */
    private static ArrayList<Integer> recursiveMultiply(ArrayList<Integer> list, int index) {
        if (list.size() == index) {
            return new ArrayList<>();
        }
        return recursiveMultiply(list, index++);
    }

    /**
     * Without modifying list, returns an array \result of
     * integers of the same size as list such that for each
     * index i of \result, \result.get(i) is the product of
     * the first i+1 elements of list.
     * @require list != null
     * @ensure      list == \old(list) &&
     *              \result.size() == list.size() &&
     *              for each index i satisfying 0 <= i < \result.size(),
     *              \result.get(i) is the product of
     *              the first i+1 elements of list
     */
    public static ArrayList<Integer> multiply(ArrayList<Integer> list) {
        ArrayList<Integer> products = new ArrayList<Integer>(); for (int i = 0; i < list.size(); i++) {
            int product;
            if (i == 0) {
                product = list.get(i);
            } else {
                product = products.get(i - 1) * list.get(i);
            }
            products.add(product);
        }
        return products;
    }

}
