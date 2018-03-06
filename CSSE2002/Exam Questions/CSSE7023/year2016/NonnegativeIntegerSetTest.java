package CSSE7023.year2016;

import org.junit.Test;


public class NonnegativeIntegerSetTest {


    @Test
    public void testMaxCapacity() {
        NonnegativeIntegerSet nn = new NonnegativeIntegerSet(5);
        nn.add(1);
        nn.add(4);
        nn.add(6);
        nn.add(44);
        nn.add(18);
        nn.add(23);
        System.out.println(nn);
    }

    @Test
    public void testWillRunForever() {
        NonnegativeIntegerSet nn = new NonnegativeIntegerSet(5);
        nn.add(1);
        nn.add(4);
        nn.add(6);
        nn.add(44);
        nn.add(18);
        nn.add(23);
        nn.add(37);
        System.out.println(nn);
    }
}