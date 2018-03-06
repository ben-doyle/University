package planner.test;

import planner.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Basic tests for the {@link Allocator} method in the
 * {@link Allocator} implementation class.
 *
 * Write your own junit4 tests for the method here.
 */
public class AllocatorTest {

    /**
     * Test Name: OneEventOneAllocationTest(
     * This test has one possible allocation
     *
     * Events - 1 event
     * [e0 (10)]
     *
     * Venue - 1 venue
     * [v0 (10)
     *   Corridor l0 to l1 (15): 10
     *   Corridor l1 to l2 (15): 10]
     *
     * Allocation1:
     *  e0 is allocated to v0
     */
    @Test(timeout = 5000)
    public void TestOneEventOneAllocation() throws
            IOException, FormatException {

        //Create empty ArrayList of events
        List<Event> events = new ArrayList<>();

        List<Venue> venues = VenueReader.read("Venues00.txt");

        Event e0 = new Event("e0", 10);
        events.add(e0);

        Map<Event, Venue> allocation = Allocator.allocate(events, venues);
        Assert.assertTrue(isAllocationSafe(allocation));
    }

    /**
     * Test Name: DocumentationEventTest
     * This test has two possible safe allocations:
     *
     * events - 3 events
     *
     * [e0 (10), e1 (7), e2 (5)]
     *
     * venues - 4 venues
     *
     * [v0 (10)
     *   Corridor l0 to l1 (15): 10
     *   Corridor l1 to l2 (15): 10,
     *
     * v1 (4)
     *   Corridor l4 to l5 (20): 4,
     *
     * v2 (10)
     *  Corridor l1 to l2 (15): 10,
     *
     * v3 (9)
     *  Corridor l3 to l4 (20): 9]
     *
     * Allocation1:
     *  e0 is allocated to v0
     *  e2 is allocated to v2
     *  e1 is allocated to v3
     *
     * Allocation2:
     *  e0 is allocated to v2
     *  e2 is allocated to v0
     *  e1 is allocated to v3
     */
    @Test(timeout = 5000)
    public void TestDocumentationExample() throws IOException, FormatException {

        //Create empty ArrayList of events
        List<Event> events = new ArrayList<>();

        List<Venue> venues = VenueReader.read("Venues01.txt");

        //Create empty ArrayList of venues
        //List<Venue> venues = new ArrayList<>();

        Event e0 = new Event("e0", 10);
        events.add(e0);
        Event e1 = new Event("e1", 7);
        events.add(e1);
        Event e2 = new Event("e2", 5);
        events.add(e2);

        Map<Event, Venue> allocation = Allocator.allocate(events, venues);
        Assert.assertTrue(isAllocationSafe(allocation));
    }

    /**
     * Test Name: Test03NoSafeAllocation
     * This test has no possible safe allocations:
     *
     * events - 3 events
     *
     * [e0 (50), e1 (17), e2 (15)]
     *
     * venues - 4 venues
     *
     * [v0 (10)
     *   Corridor l0 to l1 (15): 10
     *   Corridor l1 to l2 (15): 10,
     *
     * v1 (4)
     *   Corridor l4 to l5 (20): 4,
     *
     * v2 (10)
     *  Corridor l1 to l2 (15): 10,
     *
     * v3 (9)
     *  Corridor l3 to l4 (20): 9]
     *
     *  Allocation: None
     */
    @Test(timeout = 5000)
    public void TestNoSafeAllocation() throws IOException, FormatException {

        //Create empty ArrayList of events
        List<Event> events = new ArrayList<>();

        List<Venue> venues = VenueReader.read("Venues01.txt");

        //Create empty ArrayList of venues
        //List<Venue> venues = new ArrayList<>();

        Event e0 = new Event("e0", 50);
        events.add(e0);
        Event e1 = new Event("e1", 17);
        events.add(e1);
        Event e2 = new Event("e2", 15);
        events.add(e2);

        Map<Event, Venue> allocation = Allocator.allocate(events, venues);
        Assert.assertEquals(null, allocation);
    }

    /**
     * Test Name: Test04FiveEventTenVenueSafeAllocation
     * Allocation: Multiple.
     */
    @Test//(timeout = 5000)
    public void TestFiveEventTenVenueSafeAllocation()
            throws IOException, FormatException {

        //Create empty ArrayList of events
        List<Event> events = new ArrayList<>();

        List<Venue> venues = VenueReader.read("Venues02.txt");

        //Create empty ArrayList of venues
        //List<Venue> venues = new ArrayList<>();

        Event e0 = new Event("e0", 10);
        events.add(e0);
        Event e1 = new Event("e1", 10);
        events.add(e1);
        Event e2 = new Event("e2", 10);
        events.add(e2);
        Event e3 = new Event("e3", 10);
        events.add(e3);
        Event e4 = new Event("e4", 10);
        events.add(e4);

        Map<Event, Venue> allocation = Allocator.allocate(events, venues);
        Assert.assertTrue(isAllocationSafe(allocation));
    }

    /**
     * Test Name: Test05FiveEventTenVenueNoSafeAllocation
     * Allocation: None
     */
    @Test(timeout = 5000)
    public void TestFiveEventTenVenueNoSafeAllocation()
            throws IOException, FormatException {

        //Create empty ArrayList of events
        List<Event> events = new ArrayList<>();

        List<Venue> venues = VenueReader.read("Venues02.txt");

        //Create empty ArrayList of venues
        //List<Venue> venues = new ArrayList<>();

        Event e0 = new Event("e0", 10);
        events.add(e0);
        Event e1 = new Event("e1", 10);
        events.add(e1);
        Event e2 = new Event("e2", 20);
        events.add(e2);
        Event e3 = new Event("e3", 10);
        events.add(e3);
        Event e4 = new Event("e4", 10);
        events.add(e4);

        Map<Event, Venue> allocation = Allocator.allocate(events, venues);
        Assert.assertEquals(null, allocation);
    }

    // -----Helper Methods-------------------------------

    /**
     * Checks if an allocation is safe.
     *
     * @param mp a map of a partial or full allocation from events to venues
     * @return true if allocation does not exceed traffic on any corridor
     */
    private static boolean isAllocationSafe(Map<Event, Venue> mp) {
        Traffic t = new Traffic();
        for (Map.Entry<Event, Venue> entry : mp.entrySet()) {
            t.addTraffic(entry.getValue().getTraffic(entry.getKey()));
        }
        return t.isSafe();
    }

}
