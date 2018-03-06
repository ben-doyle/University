package CSSE2002.year2008;

public class Question1a {
    public static void main(String [] args) {
        int [] a = new int [3];
        for (int i=0; i < a.length; i++) a[i]=a.length-i-1;
        int [] b = reverse(a);
        int [] c = reverse(b);
        System.out.println(a[0]);
        System.out.println(b[0]);
        System.out.println(c[0]);
    }
    private static int [] reverse(int [] x) {
        int [] y = x;
        for (int i=0; i < x.length; i++) y[i] = x[x.length-i-1];
        return y;
    }
}
