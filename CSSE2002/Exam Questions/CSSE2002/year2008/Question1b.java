package CSSE2002.year2008;

public class Question1b {
    public static void main(String [] args) {
        int i = 1;
        int j = 2;
        int k = 3;
        int m = 2;
        System.out.println(i < k && j < m);
        System.out.println(i + j < m || m + i == k);
        System.out.println(! (i*3 < k || ! (m < j)));
    }
}
