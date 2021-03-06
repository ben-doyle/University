package planner.test;

import planner.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 * Tests for the {@link Venue} implementation class.
 */
public class CompleteVenueTest {

    // Correct line separator for executing machine (used in toString method)
    private final static String LINE_SEPARATOR = System.getProperty(
            "line.separator");
    // locations to test with
    private Location[] locations;
    // corridors to test with
    private Corridor[] corridors;
    // traffic objects to test with;
    private Traffic[] trafficRecords;
    // event objects to test with
    private Event[] events;

    /**
     * This method is run by JUnit before each test to initialise instance
     * variables locations and corridors.
     */
    @Before
    public void setUp() throws Exception {
        // locations to test with
        locations = new Location[7];
        locations[0] = new Location("l0");
        locations[1] = new Location("l1");
        locations[2] = new Location("l2");
        locations[3] = new Location("Valley");
        locations[4] = new Location("City");
        locations[5] = new Location("Toowong");
        locations[6] = new Location("St. Lucia");

        // corridors to test with
        corridors = new Corridor[7];
        corridors[0] = new Corridor(locations[0], locations[1], 100);
        corridors[1] = new Corridor(locations[1], locations[2], 200);
        corridors[2] = new Corridor(locations[3], locations[4], 300);
        corridors[3] = new Corridor(locations[4], locations[5], 400);
        corridors[4] = new Corridor(locations[4], locations[6], 500);

        // events to test with
        events = new Event[6];
        events[0] = new Event("Adele", 200);
        events[1] = new Event("Bieber", 100);
        events[2] = new Event("Foo Fighters", 50);
        events[3] = new Event("Madonna", 7);
        events[4] = new Event("Wild Marmalade", 93);
        events[5] = new Event("Cookies & Cream", 7);

        // traffic records to test with
        trafficRecords = new Traffic[6];

        trafficRecords[0] = new Traffic();
        trafficRecords[0].updateTraffic(corridors[0], 100);
        trafficRecords[0].updateTraffic(corridors[1], 200);

        trafficRecords[1] = new Traffic();
        trafficRecords[1].updateTraffic(corridors[0], 50);
        trafficRecords[1].updateTraffic(corridors[1], 100);

        trafficRecords[2] = new Traffic();
        trafficRecords[2].updateTraffic(corridors[0], 25);
        trafficRecords[2].updateTraffic(corridors[1], 50);

        trafficRecords[3] = new Traffic();
        trafficRecords[3].updateTraffic(corridors[0], 3);
        trafficRecords[3].updateTraffic(corridors[1], 7);

        trafficRecords[4] = new Traffic();
        trafficRecords[4].updateTraffic(corridors[2], 71);
        trafficRecords[4].updateTraffic(corridors[3], 51);
        trafficRecords[4].updateTraffic(corridors[4], 7);

        trafficRecords[5] = new Traffic();
        trafficRecords[5].updateTraffic(corridors[2], 5);
        trafficRecords[5].updateTraffic(corridors[3], 3);
        trafficRecords[5].updateTraffic(corridors[4], 0);

    }

    /**
     * Test from handout:
     * 
     * Test of the construction of a typical venue.
     */
    @Test(timeout = 5000)
    public void testTypicalVenue1() throws Exception {
        // venue parameters
        String name = "Suncorp Stadium";
        int capacity = 100;
        Traffic capacityTraffic = trafficRecords[1];

        // the venue under test
        Venue venue = new Venue(name, capacity, new Traffic(capacityTraffic));

        // check the name of the venue
        Assert.assertEquals(name, venue.getName());
        // check the capacity of the venue
        Assert.assertEquals(capacity, venue.getCapacity());
        // check which events the venue can host
        Assert.assertFalse(venue.canHost(events[0]));
        Assert.assertTrue(venue.canHost(events[1]));
        Assert.assertTrue(venue.canHost(events[2]));

        // check the traffic generated by an event of maximum size
        Traffic expectedTraffic = capacityTraffic;
        Traffic actualTraffic = venue.getTraffic(events[1]);
        Assert.assertTrue(expectedTraffic.sameTraffic(actualTraffic));

        // check the traffic generated by an event of half the maximum size
        expectedTraffic = trafficRecords[2];
        actualTraffic = venue.getTraffic(events[2]);
        Assert.assertTrue(expectedTraffic.sameTraffic(actualTraffic));

        // check the string representation
        String expectedString = "Suncorp Stadium (100)" + LINE_SEPARATOR
                + "Corridor l0 to l1 (100): 50" + LINE_SEPARATOR
                + "Corridor l1 to l2 (200): 100" + LINE_SEPARATOR;
        String actualString = venue.toString();
        Assert.assertEquals(expectedString, actualString);

        // check that the invariant holds
        Assert.assertTrue(venue.checkInvariant());
    }

    /**
     * Test of the construction of a typical venue + traffic generated where
     * integer truncation is necessary.
     */
    @Test(timeout = 5000)
    public void testTypicalVenue2() throws Exception {
        // venue parameters
        String name = "The Zoo";
        int capacity = 93;
        Traffic capacityTraffic = trafficRecords[4];

        // the venue under test
        Venue venue = new Venue(name, capacity, new Traffic(capacityTraffic));

        // check the name of the venue
        Assert.assertEquals(name, venue.getName());
        // check the capacity of the venue
        Assert.assertEquals(capacity, venue.getCapacity());
        // check which events the venue can host
        Assert.assertFalse(venue.canHost(events[1]));
        Assert.assertTrue(venue.canHost(events[4]));
        Assert.assertTrue(venue.canHost(events[5]));

        // check the traffic generated by an event where integer truncation is
        // necessary
        Traffic expectedTraffic = trafficRecords[5];
        Traffic actualTraffic = venue.getTraffic(events[5]);
        Assert.assertTrue(expectedTraffic.sameTraffic(actualTraffic));

        // check the traffic generated by an event of maximum size
        expectedTraffic = capacityTraffic;
        actualTraffic = venue.getTraffic(events[4]);
        Assert.assertTrue(expectedTraffic.sameTraffic(actualTraffic));

        // check the string representation
        String expectedString = "The Zoo (93)" + LINE_SEPARATOR
                + "Corridor City to St. Lucia (500): 7" + LINE_SEPARATOR
                + "Corridor City to Toowong (400): 51" + LINE_SEPARATOR
                + "Corridor Valley to City (300): 71" + LINE_SEPARATOR;
        String actualString = venue.toString();
        Assert.assertEquals(expectedString, actualString);

        // check that the invariant holds
        Assert.assertTrue(venue.checkInvariant());
    }

    /**
     * Tests that a mutable input parameter is not directly assigned to the
     * internal state in the constructor.
     */
    @Test(timeout = 5000)
    public void testInvariantProtectionConstructor() throws Exception {
        // venue parameters
        String name = "Suncorp Stadium";
        int capacity = 100;
        Traffic capacityTraffic = trafficRecords[1];
        Traffic capacityTrafficCopy = new Traffic(capacityTraffic);

        // the venue under test
        Venue venue = new Venue(name, capacity, capacityTrafficCopy);

        // change capacityTraffic to make sure that it doesn't change the venue
        capacityTrafficCopy.updateTraffic(corridors[0], 100);

        // check the name of the venue
        Assert.assertEquals(name, venue.getName());
        // check the capacity of the venue
        Assert.assertEquals(capacity, venue.getCapacity());
        // check which events the venue can host
        Assert.assertFalse(venue.canHost(events[0]));
        Assert.assertTrue(venue.canHost(events[1]));
        Assert.assertTrue(venue.canHost(events[2]));

        // check the traffic generated by an event of maximum size
        Traffic expectedTraffic = capacityTraffic;
        Traffic actualTraffic = venue.getTraffic(events[1]);
        Assert.assertTrue(expectedTraffic.sameTraffic(actualTraffic));

        // check the traffic generated by an event of half the maximum size
        expectedTraffic = trafficRecords[2];
        actualTraffic = venue.getTraffic(events[2]);
        Assert.assertTrue(expectedTraffic.sameTraffic(actualTraffic));

        // check the string representation
        String expectedString = "Suncorp Stadium (100)" + LINE_SEPARATOR
                + "Corridor l0 to l1 (100): 50" + LINE_SEPARATOR
                + "Corridor l1 to l2 (200): 100" + LINE_SEPARATOR;
        String actualString = venue.toString();
        Assert.assertEquals(expectedString, actualString);

        // check that the invariant holds
        Assert.assertTrue(venue.checkInvariant());
    }

    /**
     * Tests that a reference to a mutable variable that is part of the internal
     * state of the class is not returned by the getTraffic method.
     */
    @Test(timeout = 5000)
    public void testInvariantProtectionGetTraffic() throws Exception {
        // venue parameters
        String name = "Suncorp Stadium";
        int capacity = 100;
        Traffic capacityTraffic = trafficRecords[1];

        // the venue under test
        Venue venue = new Venue(name, capacity, new Traffic(capacityTraffic));

        // check the traffic generated by an event of maximum size
        Traffic expectedTraffic = capacityTraffic;
        Traffic actualTraffic = venue.getTraffic(events[1]);
        Assert.assertTrue(expectedTraffic.sameTraffic(actualTraffic));

        // change actualTraffic and make sure that it does not change the class
        actualTraffic.updateTraffic(corridors[0], 100);

        // the expected traffic has not changed: check that the answer hasn't
        // changed
        actualTraffic = venue.getTraffic(events[1]);
        Assert.assertTrue(expectedTraffic.sameTraffic(actualTraffic));

        // check the string representation
        String expectedString = "Suncorp Stadium (100)" + LINE_SEPARATOR
                + "Corridor l0 to l1 (100): 50" + LINE_SEPARATOR
                + "Corridor l1 to l2 (200): 100" + LINE_SEPARATOR;
        String actualString = venue.toString();
        Assert.assertEquals(expectedString, actualString);

        // check that the invariant holds
        Assert.assertTrue(venue.checkInvariant());
    }

    /**
     * Test that the appropriate NullPointerException is thrown if a venue is
     * constructed when either parameter name or capacityTraffic are null.
     */
    @Test(timeout = 5000)
    public void testNullParameters() throws Exception {
        testNullNameParameter();
        testNullTrafficParameter();
    }

    /**
     * Test that the appropriate exception is thrown if a venue is created with
     * a null name parameter.
     */
    public void testNullNameParameter() throws Exception {
        // venue parameters
        int capacity = 100;
        Traffic capacityTraffic = trafficRecords[1];

        try {
            new Venue(null, capacity, new Traffic(capacityTraffic));
            Assert.fail("NullPointerException not thrown");
        } catch (Exception e) {
            Assert.assertTrue("NullPointerException not thrown",
                    e instanceof NullPointerException);
        }
    }

    /**
     * Test that the appropriate exception is thrown if a venue is created with
     * a null capacityTraffic parameter.
     */
    public void testNullTrafficParameter() throws Exception {
        // venue parameters
        String name = "Suncorp Stadium";
        int capacity = 100;

        try {
            new Venue(name, capacity, null);
            Assert.fail("NullPointerException not thrown");
        } catch (Exception e) {
            Assert.assertTrue("NullPointerException not thrown",
                    e instanceof NullPointerException);
        }
    }

    /**
     * Test that the appropriate IllegalArgumentException if the Venue
     * constructor is called with an illegal capacity, or getTraffic is called
     * with an event that is too big.
     */
    @Test(timeout = 5000)
    public void testInvalidArgumentExceptions() throws Exception {
        testInvalidCapacityParameter();
        testInvalidEventParameter();
    }

    /**
     * Test that the appropriate exception is thrown if a venue is created with
     * a capacity less than or equal to zero.
     */
    public void testInvalidCapacityParameter() throws Exception {
        // venue parameters
        String name = "Suncorp Stadium";
        int capacity = 0;
        Traffic capacityTraffic = new Traffic(); // empty traffic

        try {
            // the venue under test
            new Venue(name, capacity, new Traffic(capacityTraffic));
            Assert.fail("IllegalArgumentException not thrown");
        } catch (Exception e) {
            Assert.assertTrue("IllegalArgumentException not thrown",
                    e instanceof IllegalArgumentException);
        }
    }

    /**
     * Test that the appropriate exception is thrown if the getTraffic is called
     * on an event that is too large.
     */
    public void testInvalidEventParameter() throws Exception {
        // venue parameters
        String name = "Suncorp Stadium";
        int capacity = 100;
        Traffic capacityTraffic = trafficRecords[1];

        // the venue under test
        Venue venue = new Venue(name, capacity, new Traffic(capacityTraffic));

        try {
            venue.getTraffic(events[0]);
            Assert.fail("IllegalArgumentException not thrown");
        } catch (Exception e) {
            Assert.assertTrue("IllegalArgumentException not thrown",
                    e instanceof IllegalArgumentException);
        }
    }

    /**
     * Test from handout:
     * 
     * Test that the appropriate exception is thrown if a venue is created with
     * a capacity traffic that is too big.
     */
    @Test(timeout = 5000, expected = InvalidTrafficException.class)
    public void testInvalidTrafficParameter() throws Exception {
        // venue parameters
        String name = "Suncorp Stadium";
        int capacity = 100;
        Traffic capacityTraffic = trafficRecords[0];

        // the venue under test
        new Venue(name, capacity, new Traffic(capacityTraffic));
    }

    /**
     * Augmented test of the equals method from handout:
     * 
     * Check of the equals method
     */
    @Test(timeout = 5000)
    public void testEquals() throws Exception {
        Venue[] venues = new Venue[6];
        venues[0] = new Venue(new String("Suncorp Stadium"), 100, new Traffic(
                trafficRecords[1]));
        venues[1] = new Venue(new String("Suncorp Stadium"), 100, new Traffic(
                trafficRecords[1]));
        venues[2] = new Venue(new String("The Gabba"), 200, new Traffic(
                trafficRecords[0]));
        venues[3] = new Venue(new String("The Gabba"), 100, new Traffic(
                trafficRecords[1]));
        venues[4] = new Venue(new String("Suncorp Stadium"), 200, new Traffic(
                trafficRecords[1]));
        venues[5] = new Venue(new String("Suncorp Stadium"), 100, new Traffic(
                trafficRecords[2]));

        // test equal venues
        Assert.assertTrue(venues[0].equals(venues[1]));
        // equal venues should have equal hash-codes
        Assert.assertEquals(venues[0].hashCode(), venues[1].hashCode());

        // test unequal venues
        Assert.assertFalse(venues[0].equals(venues[2])); // all different
        Assert.assertFalse(venues[0].equals(venues[3])); // name different
        Assert.assertFalse(venues[0].equals(venues[4])); // capacity different
        Assert.assertFalse(venues[0].equals(venues[5])); // traffic different
        Assert.assertFalse(venues[0].equals(null)); // null case
        Assert.assertFalse(venues[0].equals("A random String")); // wrong type
    }
}
