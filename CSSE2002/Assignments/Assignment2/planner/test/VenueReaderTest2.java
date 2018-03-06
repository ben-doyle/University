package planner.test;

import org.junit.Assert;
import org.junit.Test;
import planner.FormatException;
import planner.Venue;
import planner.VenueReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO: Add @ensure and @require for all private methods

/**
 * Basic tests for the {@link VenueReader} implementation class.
 * 
 * A more extensive test suite will be performed for assessment of your code,
 * but this should get you started writing your own unit tests.
 */
public class VenueReaderTest2 {

    // Correct line separator for executing machine
    private final static String LINE_SEPARATOR = System.getProperty(
            "line.separator");


    /**
     * Test reading from a file where there is one typical venue.
     */
    @Test
    public void test01() throws Exception {

        List<Venue> actualVenues = VenueReader.read("read_02_correctlyFormatted_oneVenue.txt");

    }

    /**
     * Test reading from a file where there is one typical venue.
     */
    @Test
    public void testCorrectlyFormattedOneVenue() throws Exception {
        // string representations of the venues that we expect from the file
        List<String> expectedVenues = new ArrayList<>();
        expectedVenues.add("The Zoo (93)" + LINE_SEPARATOR
                + "Corridor City to Royal Queensland Show - EKKA (400): 51"
                + LINE_SEPARATOR + "Corridor City to St. Lucia (500): 7"
                + LINE_SEPARATOR + "Corridor Valley to City (300): 71"
                + LINE_SEPARATOR);

        // the actual venues read from the file
        List<Venue> actualVenues = VenueReader.read(
                "read_02_correctlyFormatted_oneVenue.txt");
        // check that the expected and actual venues read are the same
        checkVenues(expectedVenues, actualVenues);
    }



    // -----Helper Methods-------------------------------

    /**
     * Check that the list actualVenues has all of the venues described by
     * expectedVenueStrings, in the order that they appear in that list.
     * 
     * @param expectedVenueStrings
     *            A list of the expected string representations of the venues
     *            that should appear in actualVenues.
     * @param actualVenues
     *            The list of venues to be checked against expectedVenueStrings.
     */
    private void checkVenues(List<String> expectedVenueStrings,
            List<Venue> actualVenues) {
        Assert.assertEquals(expectedVenueStrings.size(), actualVenues.size());
        for (int i = 0; i < expectedVenueStrings.size(); i++) {
            Assert.assertEquals(expectedVenueStrings.get(i), actualVenues.get(i)
                    .toString());
        }
    }

}
