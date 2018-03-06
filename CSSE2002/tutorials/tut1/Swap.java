package tut1;

public class Swap {

    public static void main(String [] args) {
        int x = 5;
        int y = 21;
        int[] c = swap(new int[] {x,y});
        x = c[0];
        y = c[1];
        System.out.println(x + "\t" + y);
    }

    private static int[] swap(int[] a) {
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
        return a;
    }

}
