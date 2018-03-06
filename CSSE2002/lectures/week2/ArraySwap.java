package week2;

import java.util.Arrays;

public class ArraySwap {

    public static void main(String[] args) {
        int[] xs = {5, 11, 3};
        int[] ys = {4, 10, 12};
        swap(xs, ys);
        System.out.println(Arrays.toString(xs));
        System.out.println(Arrays.toString(ys));
    }

    private static void swap(int[] a, int[] b) {
        int[] temp = a;
        a = b;
        b = temp;
    }

}
