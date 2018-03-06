package CSSE7023.year2016;

public class Question2a {
    public static void main(String[] args) {
        NonnegativeIntegerSet set = new NonnegativeIntegerSet(4);
        int[] list = {9, 3, 8, 4};
        for (int i =0; i < list.length; i++){
            set.add(list[i]);
        }
        System.out.println(set.toString());
    }
}
