package week3;

//remove // from next line to test list implementation
import extra.week3.WordSet;

// For brevity you can call static Assert class methods directly without 
// the class prefix if you uncomment the following import statement 
// import static org.junit.Assert.*; 

import org.junit.Assert;
import org.junit.Test;

/** JUnit tests for the WordSet class. */
public class WordSetJUnitTest {

    private WordSet w; // the object to test

    /** Tests the constructor of WordSet. */
    @Test
    public void testInitialState() {
        w = new WordSet();
        Assert.assertEquals("string", "[]", w.toString());
        Assert.assertEquals("size", 0, w.size());
        Assert.assertTrue("contains", !w.contains("cat"));
        Assert.assertTrue("Invariant failed", w.checkInvariant());
    }

    /**
     * Tests the add method of WordSet.
     * 
     * NOTE: ideally each test case tests one thing, so this method could be
     * broken up into multiple test cases.
     */
    @Test
    public void testAdd() {
        w = new WordSet();
        // check addition of single word
        w.add("cat");
        Assert.assertEquals("string", "[cat]", w.toString());
        Assert.assertEquals("size", 1, w.size());
        Assert.assertTrue("contains", w.contains("cat") && !w.contains("dog"));
        Assert.assertTrue("Invariant failed", w.checkInvariant());

        // check addition of multiple words
        w.add("dog");
        Assert.assertTrue("string", w.toString().equals("[dog, cat]")
                || w.toString().equals("[cat, dog]"));
        Assert.assertEquals("size", 2, w.size());
        Assert.assertTrue("contains",
                w.contains("cat") && w.contains("dog") && !w.contains("mouse"));
        Assert.assertTrue("Invariant failed", w.checkInvariant());

        // check addition of existing word
        w.add("cat");
        Assert.assertTrue("string", w.toString().equals("[dog, cat]")
                || w.toString().equals("[cat, dog]"));
        Assert.assertEquals("size", 2, w.size());
        Assert.assertTrue("contains",
                w.contains("cat") && w.contains("dog") && !w.contains("mouse"));
        Assert.assertTrue("Invariant failed", w.checkInvariant());
    }

    /**
     * Test that attempting to add a null word to a WordSet results in a
     * NullPointerException being thrown.
     */
    @Test(expected = NullPointerException.class)
    public void testAddNullArgument() {
        w = new WordSet();
        w.add(null);
    }

    /** Tests the remove method of WordSet. */
    @Test
    public void testRemove() {
        w = new WordSet();
        w.add("cat");
        w.add("dog");

        // check removal of a word that is not in the set
        w.remove("mouse");
        Assert.assertTrue("string", w.toString().equals("[dog, cat]")
                || w.toString().equals("[cat, dog]"));
        Assert.assertEquals("size", 2, w.size());
        Assert.assertTrue("contains",
                w.contains("cat") && w.contains("dog") && !w.contains("mouse"));
        Assert.assertTrue("Invariant failed", w.checkInvariant());

        // check removal of a word that is in the set
        w.remove("cat");
        Assert.assertEquals("string", "[dog]", w.toString());
        Assert.assertEquals("size", 1, w.size());
        Assert.assertTrue("contains", !w.contains("cat") && w.contains("dog"));
        Assert.assertTrue("Invariant failed", w.checkInvariant());
    }

}
