package tut1;

import org.junit.Test;

import static org.junit.Assert.*;


public class Tutorial1Test {
    private Tutorial1 t1 = new Tutorial1();

    @Test
    public void sum() throws Exception {
        int[] testArray = {1, 2 ,3};
        assertEquals(t1.sum(testArray), 6);
    }

    @Test
    public void countItem() throws Exception {
        int[] testArray = {1, 1, 4, 1, 5};
        assertEquals(t1.countItem(1, testArray), 3);
    }

    @Test
    public void sumArray() throws Exception {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {2, 3, 4, 5};
        int[] array3 = {0, 0, 0, 0};
        t1.sumArray(array1, array2, array3);
        assertArrayEquals(new int[] {3, 5, 7, 9}, array3);
    }

    @Test
    public void prefix() throws Exception {
        String s1 = "Magic";
        String s2 = "Magical";
        String s3 = "Magittttt";
        assertTrue(t1.prefix(s1, s2));
        assertFalse(t1.prefix(s1, s3));
    }

}