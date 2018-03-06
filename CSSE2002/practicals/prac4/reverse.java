package prac4;

public class reverse {
    public static void main(String[] args) {
        String str1 = "abc";
        System.out.println(reverse(str1));
        String str2 = "aaccfdsdf";
        System.out.println(reverse(str2));
    }

    public static String reverse(String str) {
        if (str.length() > 1) {
            return reverse(str.substring(1)) + str.charAt(0);
        } else {
            return str;
        }
    }
}
