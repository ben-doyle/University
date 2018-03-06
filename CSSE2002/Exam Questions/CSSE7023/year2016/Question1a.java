package CSSE7023.year2016;

public class Question1a {
    public static void main(String[] args) {
        int[] list = {8, 11, 12, 9, 4, 10, 3};
        int last = -1;

        for (int i=0; i < list.length; i++) {
            if (list[i] / 10 >= 1) {
                if (last == -1) {
                    last = i;
                } else {
                    list[last] = list[i];
                    last = i;
                }
            }
        }
        if (list.length != 0) {
            System.out.print(list[0]);
        }
        for (int i = 1; i < list.length; i++) {
            System.out.print(" " + list[i]);
        }
    }
}
