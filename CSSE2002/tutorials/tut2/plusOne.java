package tut2;

public class plusOne {
    public static void main (String[] args) {
        int[] x = {1, 2};
        int[] y = plusOne(x);
        System.out.println(x[0] + " " + x[1]);
        System.out.println(y[0] + " " + y[1]);
    }

    public static int[] plusOne(int[] x) {
        int[] y = x;
        x = new int[x.length];
        for (int i = 0; i < y.length; i++) {
            x[i] = y[i];
        }
        for (int i = 0; i < y.length; i++) {
            y[i] = y[i] + 1;
        }
        return y;
    }
}
