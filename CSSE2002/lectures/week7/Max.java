package week7;

public class Max {

    public static void main(String[] args) {
        int[] values = {};
        try {
            int max = findMax(values);
            System.out.println("max is " + max);
        } catch (EmptyException e) {
            System.out.println("Empty array");
        }
    }

    public static int findMax(int[] a) throws EmptyException {
        if (a.length == 0) {
            throw new EmptyException();
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
}
