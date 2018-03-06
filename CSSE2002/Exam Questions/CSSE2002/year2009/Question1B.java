package CSSE2002.year2009;

import java.util.ArrayList;

public class Question1B {
    public static void main(String [] args) {
        ArrayList list1 = new ArrayList();
        list1.add("abc");
        list1.add("123");
        ArrayList list2 = method(list1);
        list2.add("abc");
        list1.add("123");
        System.out.println(list1);
        System.out.println(list2);
    }

    private static ArrayList method(ArrayList list) {
        ArrayList result = list;
        result.remove("123");
        return result;
    }
}
