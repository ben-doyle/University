package CSSE2002.year2008;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/** Black Box Tests
 *  []                  "xyz"   0
 *  ["abc”]             “xyz”   0
 *  ["xyz"]             "xyz"   1
 *  ["abc”,”abc","abc"] "xyz"   0
 *  ["abc","xyz","abc"] "xyz"   1
 *  ["xyz","abc","abc"] "xyz"   1
 *  ["abc","abc","xyz"] "xyz"   1
 *  ["xyz","xyz","abc"] "xyz"   2
 */

/** White Box Tests
 *  []              “xyz”   0
 *  ["abc"]         "xyz"   0
 *  ["xyz"]         "xyz"   1
 *  ["abc","abc"]   "xyz"   0
 *  ["abc","xyz"]   “xyz"   1
 *  ["xyz","abc"]   "xyz"   1
 *  ["xyz","xyz"]   "xyz"   2
 */
public class Question2Test {

    /** Test the Empty List
     *  [] "xyz" 0
     */
    @Test
    public void EmptyList() throws Exception {
        List<String> test = new ArrayList<>();
        Assert.assertEquals(Question2.count(test, "xyz"), 0);
    }

    /** Test one element NOT in list.
     *  ["abc”] “xyz” 0
     */
    @Test
    public void Test1NotInList() throws Exception {
        List<String> test = new ArrayList<>();
        test.add("abc");
        Assert.assertEquals(Question2.count(test, "xyz"), 0);
    }



}