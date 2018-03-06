package one;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class toBinary {
    public static void main(String[] args) {
        String s = binary(65535);
        System.out.println("65535 in binary is " + s);
        System.out.println(recurringOnes(s));

        String s2 = binary(439);
        System.out.println(s2);
        System.out.println(recurringOnes(s2));
    }

    private static int recurringOnes(String s) {
        int num = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') {
                if (num > result) {
                    result = num;
                }
                num = 0;
            } else if (s.charAt(i) == '1') {
                num++;
                if (num > result) {
                    result = num;
                }
            }
        }
        return result;
    }

    private static String binary(int n) {
        List<Integer> ret = new ArrayList<>();
        String retu = "";
        int remainder = 0;
        while(n > 0) {
            remainder = n%2;
            n = n/2;
            ret.add(0, remainder);
        }
        for (int i = 0; i < ret.size(); i++) {
            retu += ret.get(i);
        }
        return retu;
    }
}
