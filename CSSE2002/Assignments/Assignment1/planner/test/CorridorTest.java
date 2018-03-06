package planner.test;

import org.junit.Assert;
import org.junit.Test;
import planner.Corridor;
import planner.Location;

/**
 * junit tests for the {@link Corridor} implementation class.
 */
public class CorridorTest {

    /**
     * Basic test of a basic instance of the class.
     */
    @Test
    public void testBasicConstructor() {
        Location location1 = new Location("Alderly");
        Location location2 = new Location("Bowen Hills");

        //Corridor Alderly to Bowen Hills (100)
        Corridor c1 = new Corridor(location1, location2, 100);
        c1.checkInvariant();
    }

    /**
     * Test that the Constructor method throws the appropriate exception when
     * when start and end location are equal as per the equal method.
     */
    @Test(expected = NullPointerException.class)
    public void testNullArgumentException() {
        //Location to test with
        Location location1 = new Location("Alderly");

        //Try to instantiate corridor with null start
        Corridor corridor1 = new Corridor(null, location1, 100);
        //Try to instantiate corridor with null end
        Corridor corridor2 = new Corridor(location1, null, 100);
        //Try to instantiate corridor with both null start/end
        Corridor corridor3 = new Corridor(null, null, 100);
    }

    /**
     * Test that the Constructor method throws the appropriate exception when
     * when start and end location are equal as per the equal method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIlleagalArgumentException() {
        Location location1 = new Location("Alderly");
        Corridor corridor1 = new Corridor(location1, location1, 100);
    }

    /**
     * Test the getStart method
     * Test check that the start location that is passed in when instantiated is
     * returned correctly by the getStart method.
     * <p>
     * Class invariant is checked at completion of the method.
     */
    @Test
    public void testGetStart() {
        Location location1 = new Location("Alderly");
        Location location2 = new Location("Bowen Hills");

        Corridor corridor1 = new Corridor(location1, location2, 100);
        Assert.assertEquals(location1, corridor1.getStart());
        Assert.assertTrue(corridor1.checkInvariant());
    }

    /**
     * Test the getEnd method
     * Test checks that the end location that is passed in when instantiated is
     * returned correctly by the getEnd method.
     * <p>
     * Class invariant is checked at completion of the method.
     */
    @Test
    public void testGetEnd() {
        Location location1 = new Location("Alderly");
        Location location2 = new Location("Bowen Hills");

        Corridor corridor1 = new Corridor(location1, location2, 100);

        Assert.assertEquals(location2, corridor1.getEnd());
        Assert.assertTrue(corridor1.checkInvariant());
    }

    /**
     * Test the getCapacity method of Corridor object
     * Test checks that the capacity that is passed in when the object is
     * instantiated is returned correctly by the getCapacity method
     * <p>
     * Class invariant is checked at the completion of the method.
     */
    @Test
    public void testGetCapacity() throws Exception {
        Location location1 = new Location("Alderly");
        Location location2 = new Location("Bowen Hills");

        Corridor corridor1 = new Corridor(location1, location2, 100);
        Assert.assertEquals(corridor1.getCapacity(), 100);
        Assert.assertTrue(corridor1.checkInvariant());
    }

    /**
     * Test of the toString method.
     */
    @Test
    public void testToString() {
        //Corridors in order for testing.
        Location l1 = new Location("Alderly");
        Location l2 = new Location("Bowen Hills");

        //Corridor Alderly to Bowen Hills (100)
        Corridor c1 = new Corridor(l1, l2, 100);
        String expected = "Corridor Alderly to Bowen Hills (100)";
        Assert.assertEquals(c1.toString(), expected);
    }

    /**
     * Test of the equals method
     * Test checks that of three corridor objects, two are equal by the equals
     * method, and the other is not.
     * <p>
     * Class invariant of each object is checked at the completion of method.
     */
    @Test
    public void testEquals() {

        //Corridors in order for testing.
        Location l1 = new Location("Alderly");
        Location l2 = new Location("Bowen Hills");
        Location l3 = new Location("Canon Hill");

        //Corridor Alderly to Bowen Hills (100)
        Corridor c1 = new Corridor(l1, l2, 100);
        //Corridor Alderly to Bowen Hills (100)
        Corridor c2 = new Corridor(l1, l2, 100);
        //Corridor Bowen Hills to Alderly (100)
        Corridor c3 = new Corridor(l2, l1, 100);

        //Test equal corridors (same object)
        Assert.assertTrue(c1.equals(c1));
        //Test equal corridors
        Assert.assertTrue(c1.equals(c2));
        //Test separate corridors aren't equal
        Assert.assertFalse(c1.equals(c3));

        Assert.assertTrue(c1.checkInvariant());
        Assert.assertTrue(c2.checkInvariant());
        Assert.assertTrue(c3.checkInvariant());
    }

    /**
     * Test the hashcode implementation.
     */
    @Test
    public void testHashCode() {
        //Corridors in order for testing.
        Location location1 = new Location("Alderly");
        Location location2 = new Location("Bowen Hills");

        Corridor c1 = new Corridor(location1, location2, 100);
        Corridor c2 = new Corridor(location1, location2, 100);
        Corridor c3 = new Corridor(location1, location2, 150);

        //Test Hashcode for equal corridor (same object)
        Assert.assertEquals(c1.hashCode(), c1.hashCode());
        //Test Hashcode for equal corridor
        Assert.assertEquals(c1.hashCode(), c2.hashCode());
        //Test Hashcode same locations, different capacity
        Assert.assertNotEquals(c1.hashCode(), c3.hashCode());

        Assert.assertTrue(c1.checkInvariant());
        Assert.assertTrue(c2.checkInvariant());
        Assert.assertTrue(c3.checkInvariant());
    }

    /**
     * Test of the compareTo method
     */
    @Test
    public void testCompareTo() {
        //Corridors in order for testing.
        Location l1 = new Location("Alderly");
        Location l2 = new Location("Bowen Hills");
        Location l3 = new Location("Canon Hill");

        //Corridor Alderly to Bowen Hills (100)
        Corridor c1 = new Corridor(l1, l2, 100);
        //Corridor Alderly to Bowen Hills (100)
        Corridor c2 = new Corridor(l1, l2, 100);
        //Corridor Bowen Hills to Alderly (100)
        Corridor c3 = new Corridor(l2, l1, 100);
        //Corridor Alderly to Canon Hill (100)
        Corridor c4 = new Corridor(l1, l3, 100);
        //Corridor Alderly to Canon Hill (100)
        Corridor c5 = new Corridor(l1, l2, 100);
        //Corridor Alderly to Canon Hill (100)
        Corridor c6 = new Corridor(l1, l2, 150);

        //Test equal corridors (same object)
        Assert.assertTrue(c1.compareTo(c1) == 0);
        //Test equal corridors
        Assert.assertTrue(c1.compareTo(c2) == 0);

        //Test greater start location.
        Assert.assertTrue(c3.compareTo(c1) > 0);
        //Test greater end location
        Assert.assertTrue(c4.compareTo(c1) > 0);
        //Test same start/end, greater capacity
        Assert.assertTrue(c6.compareTo(c5) > 0);

        //Test lower start location.
        Assert.assertTrue(c1.compareTo(c3) < 0);
        //Test lower end location
        Assert.assertTrue(c1.compareTo(c4) < 0);
        //Test same start/end, lower capacity
        Assert.assertTrue(c5.compareTo(c6) < 0);

    }

}

