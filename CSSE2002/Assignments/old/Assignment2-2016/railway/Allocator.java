package railway;

import java.util.*;

public class Allocator {

    /**
     * This method takes as input a list of the routes that are currently
     * occupied by trains on the track, and a list of the routes requested by
     * each of those trains and returns an allocation of routes to trains based
     * on those inputs.
     * 
     * Such a method may be used by a train controller to manage the movement of
     * trains on the track so that they do not collide. (I.e. if a train has
     * been allocated to a route, it has permission to travel on that route.)
     * 
     * @require occupied != null && requested != null
     * 
     *          && !occupied.contains(null)
     * 
     *          && !requested.contains(null)
     * 
     *          && occupied.size() == requested.size()
     * 
     *          && none of the occupied routes intersect
     * 
     *          && the routes in the occupied list are non-empty, valid routes
     * 
     *          && the routes in the requested list are non-empty, valid routes
     * 
     *          && all the routes in occupied and requested are part of the same
     *          track.
     * 
     * @ensure Let N be the number of elements in the occupied list. This method
     *         returns a list of N routes, where, for each index i satisfying 0
     *         <= i < N, \result.get(i) is the route allocated to the ith train:
     *         the train currently occupying route occupied.get(i).
     * 
     *         The route allocated to the ith train is the longest prefix of
     *         requested.get(i) that does not intersect with any of the routes
     *         currently occupied by any other train, or any of the routes
     *         \result.get(j) for indices j satisfying 0 <= j < i. (I.e. trains
     *         with lower indices have higher priority.)
     * 
     *         Neither of the two input parameters, the occupied list and the
     *         requested list, are modified in any way by this method.
     *
     * @param occupied
     *            there are occupied.size() trains on the track, and parameter
     *            occupied is a list of the routes currently occupied by each of
     *            those trains. A precondition of this method is that none of
     *            the occupied routes are null or empty, they are valid routes,
     *            and that they do not intersect (i.e. no two trains can occupy
     *            the same location on the track at the same time).
     * @param requested
     *            a list of the routes requested by each of the occupied.size()
     *            trains. A precondition of the method is that occupied.size()
     *            == requested.size(), and that none of the requested routes are
     *            null or empty, and that they are valid routes. For index i
     *            satisfying 0 <= i < requested.size(), requested.get(i) is the
     *            route requested by the train currently occupying the route
     *            occupied.get(i).
     * @return the list of allocated routes.
     */
    public static List<List<Segment>> allocate(List<List<Segment>> occupied,
            List<List<Segment>> requested) {

        // the routes allocated to each train, initialized to be the empty list
        List<List<Segment>> granted = new ArrayList<>();

        // for each train i, allocate the maximum prefix of the requested route
        for (int i = 0; i < occupied.size(); i++) {
            /*
             * The longest prefix of requested.get(i) that can be allocated to
             * train i based on the currently occupied segments of track, and
             * the segments of track that have already been allocated to
             * higher-priority trains. Initialized to the requested route.
             */
            List<Segment> longestPrefix =
                    new ArrayList<Segment>(requested.get(i));
            /*
             * Update longestPrefix to be the longest prefix that doesn't
             * overlap with any of the segments of track currently occupied by
             * any other train.
             */
            for (int j = 0; j < occupied.size(); j++) {
                if (i != j) {
                    longestPrefix =
                            longestDisjointPrefix(longestPrefix, occupied
                                    .get(j));
                }
            }
            /*
             * Update longestPrefix to be the longest prefix that doesn't
             * overlap with any of the segments of track that have already been
             * allocated to higher priority trains.
             */
            for (int j = 0; j < i; j++) {
                longestPrefix =
                        longestDisjointPrefix(longestPrefix, granted.get(j));
            }
            granted.add(longestPrefix); // add to the ith position in granted
        }
        return granted;
    }

    /**
     * Returns the longest prefix of routeA that doesn't intersect with routeB.
     * 
     * @require routeA != null && routeB != null && !routeA.contains(null) &&
     *          !routeB.contains(null)
     * @ensure returns the longest prefix of routeA that doesn't overlap with
     *         any of the locations in routeB.
     */
    private static List<Segment> longestDisjointPrefix(List<Segment> routeA,
            List<Segment> routeB) {
        // the longest disjoint prefix of routeA (to be calculated)
        List<Segment> result = new ArrayList<Segment>();

        for (Segment segmentA : routeA) {
            // calculate the longest disjoint prefix of segmentA and routeB
            Segment prefix = segmentA;
            for (Segment segmentB : routeB) {
                prefix = longestDisjointPrefix(prefix, segmentB);
                if (prefix == null) {
                    // only a trivial prefix of segmentA doesn't intersect: the
                    // result calculated so far is the longest disjoint prefix
                    return result;
                }
            }
            result.add(prefix);
            if (!segmentA.equals(prefix)) {
                // segmentA does intersect with routeB: the
                // result calculated so far is the longest disjoint prefix
                return result;
            }
        }
        return result;
    }

    /**
     * Returns the longest prefix of segmentA that doesn't intersect with
     * segmentB. The value null is returned if such a segment would be empty or
     * have length 0.
     * 
     * @require segmentA != null && segmentB != null
     * @ensure returns the longest prefix of segmentA that doesn't overlap with
     *         any of the locations in segmentB. The value null is returned if
     *         such a segment would be empty or have length 0.
     */
    private static Segment longestDisjointPrefix(Segment segmentA,
            Segment segmentB) {

        if (!segmentA.getSection().equals(segmentB.getSection())) {
            // (i) They are not on the same section.
            // Only the first or last locations might overlap in this case.

            if (segmentB.contains(segmentA.getFirstLocation())) {
                // the longest disjoint prefix is empty
                return null;
            } else if (segmentB.contains(segmentA.getLastLocation())) {
                // the prefix has all but the last location of segmentA
                if (segmentA.getLength() == 1) {
                    return null; // the longest disjoint prefix has length 0
                } else {
                    return new Segment(segmentA.getSection(), segmentA
                            .getDepartingEndPoint(), segmentA.getStartOffset(),
                            segmentA.getEndOffset() - 1);
                }
            } else {
                // segmentA and segmentB do not intersect
                return segmentA;
            }
        } else {
            // (ii) They are on the same section.
            // We first invert segmentB's direction if necessary so that its
            // interval on the section can be readily compared to segmentA's.
            if (!segmentB.getDepartingEndPoint().equals(
                    segmentA.getDepartingEndPoint())) {
                segmentB = invertDirection(segmentB);
            }

            if (segmentA.getEndOffset() < segmentB.getStartOffset()
                    || segmentB.getEndOffset() < segmentA.getStartOffset()) {
                // the intervals do not overlap
                return segmentA;
            } else {
                // the intervals do overlap
                if (segmentB.getStartOffset() <= segmentA.getStartOffset()) {
                    // the first location in segmentA is also in segmentB.
                    return null; // the longest disjoint prefix is empty
                } else {
                    // the first location of segmentA is not in segmentB.
                    if (segmentB.getStartOffset() - 1
                            - segmentA.getStartOffset() < 1) {
                        return null; // the longest disjoint prefix has length 0
                    } else {
                        return new Segment(segmentA.getSection(), segmentA
                                .getDepartingEndPoint(), segmentA
                                .getStartOffset(),
                                segmentB.getStartOffset() - 1);
                    }
                }
            }
        }
    }

    /**
     * Returns a segment that occupies the same locations as the given segment,
     * but whose direction of travel has been reversed.
     * 
     * @require segment != null
     * @ensure returns the inverted segment
     */
    private static Segment invertDirection(Segment segment) {
        // the parameters of the inverted section
        Section section = segment.getSection();
        JunctionBranch endPoint =
                section.otherEndPoint(segment.getDepartingEndPoint());
        int startOffset = section.getLength() - segment.getEndOffset();
        int endOffset = section.getLength() - segment.getStartOffset();
        return new Segment(section, endPoint, startOffset, endOffset);
    }

}
