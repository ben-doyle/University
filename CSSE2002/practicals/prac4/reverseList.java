package prac4;

import java.util.LinkedList;

public class reverseList {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(5);
        integers.add(7);
        integers.add(14);

        integers = reverseList(integers);

        System.out.println(integers);
    }

    private static LinkedList<Integer> reverseList(LinkedList<Integer> list) {
        if (list.size() == 0) {
            return new LinkedList<>();
        } else {
            Integer toAdd = list.poll();
            LinkedList<Integer> result = reverseList(list);
            result.add(toAdd);
            return result;
        }
    }
}
