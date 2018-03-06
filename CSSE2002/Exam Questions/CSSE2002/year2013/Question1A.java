package CSSE2002.year2013;

public class Question1A {
    public static void main(String[] args) {
        StringBuilder[] x = {   new StringBuilder("a"),
                                new StringBuilder("b"),
                                new StringBuilder("c")};
        StringBuilder s = concat(x);
        printArray(x);
        System.out.println(s);
    }

    private static StringBuilder concat(StringBuilder[] x) {
        StringBuilder s = x[0];
        for (int i = 1; i < x.length ; i++) {
            s.append(x[i]);
        }
        return s;
    }

    private static void printArray(StringBuilder[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        if (a.length != 0) {
            System.out.println(a[a.length - 1]);
        }

    }
}
