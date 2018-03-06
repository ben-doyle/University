package one;

public class RandomArrayTest {

    public static void main(String[] args) {

        RandomArray r = new RandomArray();
        int size = 10;
        int[] r1 = r.RandomArray(size);
        for (int i = 0; i < size; i++) {
            System.out.println(r1[i]);
        }
    }
}
