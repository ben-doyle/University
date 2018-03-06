package week7;

import java.util.Scanner;

public class Divide {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.printf("Please enter the first int: ");
            String s1 = scan.next();
            System.out.printf("Please enter the second int: ");
            String s2 = scan.next();
//            String s1 = args[0];
//            String s2 = args[1];
            int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s2);
            double div = (100 * a / b) / 100.0;
            System.out.println(a + "/" + b + " = " + div);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "Not enough arguments: two integer arguments are required.");
        } catch (NumberFormatException e) {
            System.out.println("Arguments must be integers: " + e.getMessage());
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
        System.out.println("Done.");
    }
}