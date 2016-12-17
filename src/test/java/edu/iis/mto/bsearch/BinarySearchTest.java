package edu.iis.mto.bsearch;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BinarySearchTest {

    public Object[][] parameters() {
        final Object[][] objects = {
                {"sequence which contains only one element", new int[]{1}, 1, 0},
                {"sequence with more than one element", new int[]{1, 2, 3}, 1, 0},
                {"sequence with more than one element", new int[]{1, 2, 3}, 3, 2},
                {"sequence with more than one element", new int[]{1, 2, 3}, 2, 1},
        };
        return objects;
    }

    @Test
    @Parameters(method = "parameters")
    @TestCaseName("searched element {2}, which is presented in {0} {1}, should be at position {3}")
    public void isFound(String name, int[] seq, int searchedElement, int expectedSearchElementPosition) {
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(expectedSearchElementPosition));
        assertThat(seq[searchResult.getPosition()], is(searchedElement));
    }

    @Test
    public void elementIsNotPresentedInSequenceAndSequenceLengthEqualsOne() {
        final int searchedElement = 1;
        final int[] seq = {0};
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test
    public void elementIsNotInTheSequenceAndSequenceLengthIsLargerThanOne() {
        final int searchedElement = 4;
        final int[] seq = {1, 2, 3};
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenSequenceIsEmpty() {
        final int searchedElement = 4;
        final int[] emptySeq = {};
        BinarySearch.search(searchedElement, emptySeq);
    }
}
