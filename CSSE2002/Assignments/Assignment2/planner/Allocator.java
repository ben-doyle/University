package planner;

import java.util.*;

/**
 * Provides a method for finding a safe allocation of events to venues.
 */
public class Allocator {

    /**
     * <p>
     * Returns a safe allocation of events to venues, if there is at least one
     * possible safe allocation, or null otherwise.
     * </p>
     * <p>
     * <p>
     * NOTE: What it means for an allocation of events to venues to be safe is
     * defined in the assignment handout.
     * </p>
     *
     * @require events != null && venues != null && !events.contains(null) &&
     * !venues.contains(null) && events does not contain duplicate
     * events && venues does not contain duplicate venues.
     * @ensure Returns a safe allocation of events to venues, if there is at
     * least one possible safe allocation, or null otherwise.
     */
    public static Map<Event, Venue> allocate(List<Event> events,
                                             List<Venue> venues) {
        // DO NOT MODIFY THE IMPLEMENTATION OF THIS METHOD
        Set<Map<Event, Venue>> allocations = allocations(events, venues);
        if (allocations.isEmpty()) {
            // returns null to signify that there is no possible safe allocation
            return null;
        } else {
            // returns one (any one) of the possible safe allocations
            int i = 1;
            for (Map<Event, Venue> mp : allocations) {
//                System.out.println("Allocation" + i + ": ");
//                for (Map.Entry<Event, Venue> entry : mp.entrySet()) {
//                    System.out.println(entry.getKey().getName() + " is allocated to " + entry.getValue().getName());
//                }
//                System.out.println();
                i++;
            }
            System.out.println((i - 1) + " possible safe allocations");
            System.out.println();
            return allocations.iterator().next();
        }
    }

    /**
     * Returns the set of all possible safe allocations of events to venues.
     *
     * @require events != null && venues != null && !events.contains(null) &&
     * !venues.contains(null) && events does not contain duplicate
     * events && venues does not contain duplicate venues.
     * @ensure Returns the set of all possible safe allocations of events to
     * venues. (Note: if there are no possible allocations, then this
     * method should return an empty set of allocations.)
     */
    private static Set<Map<Event, Venue>> allocations(List<Event> events,
                                                      List<Venue> venues) {
        Set<Map<Event, Venue>> allocations = new HashSet<>();

        if (events.isEmpty()) {
            allocations.add(new HashMap<>());
            return allocations;
        }

        for (int i = 0; i < venues.size() ; i++) {
            if (venues.get(i).canHost(events.get(0))) {
                Venue v = venues.get(i);
                Map<Event, Venue> m = new HashMap<>();
                m.put(events.get(0), v);

                //A copy of events for use, as to not be destructive when it
                // gets called on again
                List<Event> eventtmp = new ArrayList<>(events);
                eventtmp.remove(0);

                venues.remove(v);

                Set<Map<Event, Venue>> temp = allocations(eventtmp, venues);
                for (Map<Event, Venue> mp : temp) {
                    if (isAllocationSafe(mp)) {
                        for (Map.Entry<Event, Venue> entry : mp.entrySet()) {
                            m.put(entry.getKey(), entry.getValue());
                        }
                    }
                }

                if (m.size() == events.size()) {
                    allocations.add(m);
                }
                venues.add(v);
            }

        }
        return allocations;
    }

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
