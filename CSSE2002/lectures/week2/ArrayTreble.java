package week2;

import java.util.Arrays;

public class ArrayTreble {

    public static void main(String[] args) {
        int[] xs = {5, 11, 3};
        treble(xs);
        System.out.println(Arrays.toString(xs));
    }

    private static void treble(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 3 * a[i];
        }
    }

}
