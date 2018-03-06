package week2;

public class Swap {

    public static void main(String[] args) {
        int x = 5;
        int y = 21;
        swap(x, y);
        System.out.println(x + "\t" + y);
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

}
