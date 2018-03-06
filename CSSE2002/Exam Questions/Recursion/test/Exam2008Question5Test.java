package Recursion.test;

import Recursion.Exam2008Question5;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class Exam2008Question5Test {
    private ArrayList<Integer> ar = new ArrayList<>();
    int testInt;

    @Before
    public void initialise() {
        testInt = (int) (Math.random() * 100);
        for (int i = 0; i < 1000; i++) {
            ar.add((int) (Math.random() * 100));
        }
    }

    @Test
    public void TestRecursiveCount() throws Exception {
        System.out.println("Numbers tested with: " + ar);
        System.out.println("elem: " + testInt);
        System.out.println(testInt + " occurs " + Exam2008Question5.count(ar, testInt) + " times in array");

        Assert.assertEquals(Exam2008Question5.recursiveCount(ar, testInt), Exam2008Question5.count(ar, testInt));
    }

}