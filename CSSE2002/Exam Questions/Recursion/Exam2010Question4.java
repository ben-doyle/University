package Recursion;

import java.util.Arrays;
import java.util.List;

public class Exam2010Question4 {
    public static void main(String[] args) {
        Integer[] intArray = {1, 1, 4, 5, 6, 8, 10};
        remove(Arrays.asList(intArray), 1);
        System.out.println(intArray);

        Integer[] intArray2 = {1, 1, 4, 5, 6, 8, 10};
        recursiveRemove(Arrays.asList(intArray2), 1);
        System.out.println(intArray2);
    }

    /**
     * TODO: Recursive method
     */
    private static <T> void recursiveRemove(List<T> list, T elem) {

    }

    /**
     * Removes all occurrences of elem from list.
     *
     * @require list != null && elem != null
     * @ensure list = \old(list) with all occurrences of elem removed
     */
    public static <T> void remove(List<T> list, T elem) {
        //Loop invariant: As i progresses through list, all list.get(i), i < list.size has no occurrences of elem.
        //Answer: There are no occurrences of elem in list with index less than i.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(elem)) {
                list.remove(i);
                i--; // need to consider the new ith element
            }
        }
    }
}
