package Recursion;


public class Exam2011Question4 {
    public static void main(String[] args) {
        System.out.println(gcd(5468, 121));
        System.out.println(recursiveGcd(5468, 121));
    }

    /**
     * Find the Greatest Common Denominator.
     */
    private static int recursiveGcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        if (x > y) {
            return recursiveGcd(x - y, y);
        } else {
            return recursiveGcd(x, y - x);
        }
    }



    /**
     * Find the Greatest Common Denominator.
     */
    public static int gcd(int x, int y) {
        int a = x;
        int b = y;
        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

}
